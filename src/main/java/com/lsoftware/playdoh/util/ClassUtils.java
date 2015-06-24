package com.lsoftware.playdoh.util;

class ClassUtils {

    public static String getClassNameFromArray(Class type) {
        return type.getSimpleName().substring(0, type.getSimpleName().length() - 2);
    }

}
