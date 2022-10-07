package com.fw.web;

import com.biz.board.Board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MasterController extends HttpServlet {

    private static final long serialVersionUID = -5640095129678177246L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();

        String jspUrl = null;

        if ("/callList".equals(pathInfo)) {
            Board board = new Board();
            jspUrl = board.callList(req);
        } else if ("/callWrite".contentEquals(pathInfo)) {
            Board board = new Board();
            jspUrl = board.callWrite(req);
        } else if ("/exeWrite".contentEquals(pathInfo)) {
            Board board = new Board();
            jspUrl = board.exeWrite(req);
        }

        if (jspUrl == null) {
            throw new ServletException();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(jspUrl);
        dispatcher.forward(req, resp);
    }
}
