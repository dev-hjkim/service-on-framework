package com.biz.board;

import javax.servlet.http.HttpServletRequest;

public class Board {
    public String callList(HttpServletRequest request) {
        String findStr = request.getParameter("findStr");

        System.out.println(findStr);

        return "/WEB-INF/classes/com/biz/board/jsp/list.jsp";
    }

    public String callWrite(HttpServletRequest request) {
        return "/WEB-INF/classes/com/biz/board/jsp/write.jsp";
    }

    public String exeWrite(HttpServletRequest request) {
        request.setAttribute("exeWriteResult", "ok");

        return callList(request);
    }
}
