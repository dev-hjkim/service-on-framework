package com.biz.board;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BoardServlet extends HttpServlet {

    private static final long serialVersionUID = 5143132710754482072L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mode = req.getParameter("mode");
        PrintWriter out = resp.getWriter();

        if ("callList".equals(mode)) {
            callList(req, out);
            return;
        }

        if ("callWrite".equals(mode)) {
            callWrite(req, out);
            return;
        }

        if ("exeWrite".equals(mode)) {
            exeWrite(req, out);
            return;
        }

        out.println("mode=" + mode);
    }

    void callList(HttpServletRequest req, PrintWriter out) {
        out.print("this View callList");
    }

    void callWrite(HttpServletRequest req, PrintWriter out) {
        out.print("this View callWrite");
    }

    void exeWrite(HttpServletRequest req, PrintWriter out) {
        out.print("exeWrite ok");
    }
}
