package com.fw.web;

import com.biz.board.BoardServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;
import java.io.File;

public class RunCodeBySimple {
    public static void main(String[] args) throws Exception {
        String root = new File(".").getAbsolutePath();

        String baseDir = root + File.separatorChar + "temp";

        int webPort = 18080;

        Tomcat tomcat = new Tomcat();

        tomcat.setBaseDir(baseDir);
        tomcat.setPort(webPort);

        Context context = tomcat.addContext("/", baseDir);

        HttpServlet board = new BoardServlet();

        tomcat.addServlet("/", "board", board);

        context.addServletMappingDecoded("/board", "board");

        tomcat.start();
        tomcat.getServer().await();
    }
}
