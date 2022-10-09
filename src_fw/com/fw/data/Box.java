package com.fw.data;

import java.io.Serializable;

public abstract class Box implements Serializable {

    private static final long serialVersionUID = 1220016007819012336L;

    public abstract void put(String key, Object object);

    public abstract Object get(String key);
}
