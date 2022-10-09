package com.fw.web;

import com.fw.data.Box;
import com.fw.data.BoxLocal;

public class BoxContext {

    private static ThreadLocal<Box> threadLocal = new ThreadLocal<>();

    static void set(Box box) {
        threadLocal.set(box);
    }

    static void remove() {
        threadLocal.remove();
    }

    public static Box get() {
        Box box = threadLocal.get();

        if (box != null) {
            return box;
        }

        box = new BoxLocal();
        set(box);
        return box;
    }
}
