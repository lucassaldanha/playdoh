package com.lsoftware.playdoh.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimitivesTest {

    @Test
    public void testGetWrapperForIntShouldReturnInteger() throws Exception {
        assertEquals(Integer.class, Primitives.getWrapper(int.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWrapperForIntegerShouldThrowIllegalStateException() throws Exception {
        assertEquals(Integer.class, Primitives.getWrapper(Integer.class));
    }

    @Test
    public void testIsPrimitiveShouldBeTrueForInt() throws Exception {
        assertTrue(Primitives.isPrimitive(int.class));
    }

    @Test
    public void testIsPrimitiveShouldBeFalseForString() throws Exception {
        assertFalse(Primitives.isPrimitive(String.class));
    }

    @Test
    public void testIsPrimitiveArrayShouldBeTrueForIntArray() throws Exception {
        assertTrue(Primitives.isPrimitiveArray(int[].class));
    }

    @Test
    public void testIsPrimitiveArrayShouldBeFalseForStringArray() throws Exception {
        assertFalse(Primitives.isPrimitiveArray(String[].class));
    }
}