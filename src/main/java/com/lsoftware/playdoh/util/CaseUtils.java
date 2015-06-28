package com.lsoftware.playdoh.util;

import com.google.common.base.CaseFormat;

public class CaseUtils {

    public static String toSnakeCase(String s) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, s);
    }
}
