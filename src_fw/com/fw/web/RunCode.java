package com.fw.web;

import com.fw.data.InitYaml;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

import java.net.Socket;
import java.util.Properties;

public class RunCode {
    public static void main(String[] args) throws Exception {
        InitYaml init = InitYaml.get();

        if (!init.isRead()) {
            return;
        }

        String tempDir = init.getTempDir();
        int webPort = init.getWebPort();
        String webappDir = init.getWebAppDir();

        System.out.println("hostName [" + init.getHostName() + "]");
        System.out.println("webappDir [" + webappDir + "]");
        System.out.println("webPort [" + webPort + "]");
        System.out.println("tempDir [" + tempDir + "]");

        if (!isWebPort(webPort)) {
            System.out.println(webPort + "는 사용중입니다.");
            return;
        }

        Properties properties = System.getProperties();
        properties.setProperty("com.app.name", "CODE");

        Tomcat tomcat = new Tomcat();

        tomcat.setBaseDir(tempDir);
        tomcat.setPort(webPort);
        tomcat.addWebapp("", webappDir);

        String characterSet = init.getCharacterSet();
        System.out.println("uri characterSet [" + characterSet + "]");
        Connector conn = tomcat.getConnector();
        conn.setURIEncoding(characterSet);

        tomcat.start();

        System.out.println("=======================================");
        System.out.println("        ☆☆☆ CODE started ☆☆☆        ");
        System.out.println("=======================================");

        tomcat.getServer().await();
    }

    private static boolean isWebPort(int webPort) throws Exception {

        Socket socket = null;
        try {
            socket = new Socket("localhost", webPort);
            socket.setSoTimeout(1);
            if (socket.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception ex) {
            return true;
        } finally {
            if (socket != null) {
                socket.close();
            }
        }

    }
}
