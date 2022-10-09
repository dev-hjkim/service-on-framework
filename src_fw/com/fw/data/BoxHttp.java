package com.fw.data;

import javax.servlet.http.HttpServletRequest;

public class BoxHttp extends Box {

    private static final long serialVersionUID = 8830881007027494374L;

    private HttpServletRequest request = null;

    public BoxHttp(HttpServletRequest request) {
        this.request = request;
    }

    public Object get(String key) {
        Object obj = request.getAttribute(key);

        if (obj != null) {
            return obj;
        }

        return this.request.getParameter(key);
    }

    public void put(String key, Object obj) {
        this.request.setAttribute(key, obj);
    }
}
