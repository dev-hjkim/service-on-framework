package com.fw.web;

import org.apache.catalina.startup.Tomcat;

import java.util.ResourceBundle;

public class RunCodeByResourceBundle {

    public static void main(String[] args) throws Exception {
        String classpath = System.getProperty("java.class.path");
        String[] classpaths = classpath.split(";");
        for (String s : classpaths) {
            System.out.println(s);
        }

        ResourceBundle init = ResourceBundle.getBundle("com.fw.init");

        String webappDir = init.getString("webappDir");
        String baseDir = init.getString("baseDir");
        int webPort = Integer.parseInt(init.getString("webPort"));

        Tomcat tomcat = new Tomcat();

        tomcat.addWebapp("", webappDir);
        tomcat.setBaseDir(baseDir);
        tomcat.setPort(webPort);

        tomcat.start();
        System.out.println("code start");
        tomcat.getServer().await();
    }
}
