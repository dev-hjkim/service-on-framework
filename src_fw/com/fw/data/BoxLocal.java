package com.fw.data;

import java.util.HashMap;

public class BoxLocal extends Box {

    private static final long serialVersionUID = 794822106507015149L;

    private HashMap<String, Object> hashMap = new HashMap<>();

    public BoxLocal() {}


    public Object get(String key) {
        return this.hashMap.get(key);
    }

    public void put(String key, Object obj) {
        this.hashMap.put(key, obj);
    }
}
