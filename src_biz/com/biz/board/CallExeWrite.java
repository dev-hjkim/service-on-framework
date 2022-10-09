package com.biz.board;

import com.fw.data.Box;
import com.fw.web.BoxContext;

public class CallExeWrite {
    public static void main(String[] args) {
        Box box = BoxContext.get();
        box.put("txt", "ABCD");

        Board b = new Board();
        b.exeWrite();

        for (int i=0; i<10; i++) {
            box.put("txt", "ABCD" + i);
            b.exeWrite();
        }
    }
}
