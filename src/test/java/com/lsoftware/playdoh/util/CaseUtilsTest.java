package com.lsoftware.playdoh.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaseUtilsTest {

    @Test
    public void testSimpleClassNameToSnakeCase() {
        assertEquals("user", CaseUtils.toSnakeCase("User"));
    }

    @Test
    public void testComposedClassNameToSnakeCase() {
        assertEquals("hello_world", CaseUtils.toSnakeCase("HelloWorld"));
    }

    @Test
    public void testWrongFormattedNameToSnakeCaseShouldReturnInputString() {
        assertEquals("aname", CaseUtils.toSnakeCase("aname"));
    }

}