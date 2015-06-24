package com.lsoftware.playdoh;

public class Playdoh {

    public static <T> T build(Class<T> type) {
        return ObjectBuilder.getInstance().build(type);
    }

    public static ObjectBuilder builder() {
        return ObjectBuilder.getInstance();
    }

}
