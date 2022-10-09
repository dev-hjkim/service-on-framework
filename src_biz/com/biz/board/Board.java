package com.biz.board;

import com.fw.data.Box;
import com.fw.web.BoxContext;

public class Board {

    public String callList() {
        Box box = BoxContext.get();

        String findStr = (String) box.get("findStr");

        box.put("list", "list=[" + findStr + "]");

        return "/WEB-INF/classes/com/biz/board/jsp/list.jsp";
    }

    public String callWrite() {
        return "/WEB-INF/classes/com/biz/board/jsp/write.jsp";
    }

    public String exeWrite() {
        Box box = BoxContext.get();

        String txt = (String) box.get("txt");

        System.out.println("exeWrite [" + txt + "]");

        box.put("exeWriteResult", "ok");

        return callList();
    }
}
