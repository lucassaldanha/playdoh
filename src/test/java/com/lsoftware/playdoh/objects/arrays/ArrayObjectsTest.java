package com.lsoftware.playdoh.objects.arrays;

import com.lsoftware.playdoh.Playdoh;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ArrayObjectsTest {

    @Test
    public void testGenerateObjectWithBooleanArray() throws Exception {
        ObjectWithBooleanArray obj = Playdoh.build(ObjectWithBooleanArray.class);
        assertNotNull(obj);
        assertTrue(obj.getPrimitiveArray().length > 0);
        assertTrue(obj.getWrapperArray().length > 0);
    }

    @Test
    public void testGenerateObjectWithByteArray() throws Exception {
        ObjectWithByteArray obj = Playdoh.build(ObjectWithByteArray.class);
        assertNotNull(obj);
        assertTrue(obj.getPrimitiveArray().length > 0);
        assertTrue(obj.getWrapperArray().length > 0);
    }

    @Test
    public void testGenerateObjectWithCharArray() throws Exception {
        ObjectWithCharArray obj = Playdoh.build(ObjectWithCharArray.class);
        assertNotNull(obj);
        assertTrue(obj.getPrimitiveArray().length > 0);
        assertTrue(obj.getWrapperArray().length > 0);
    }

    @Test
    public void testGenerateObjectWithDoubleArray() throws Exception {
        ObjectWithDoubleArray obj = Playdoh.build(ObjectWithDoubleArray.class);
        assertNotNull(obj);
        assertTrue(obj.getPrimitiveArray().length > 0);
        assertTrue(obj.getWrapperArray().length > 0);
    }

    @Test
    public void testGenerateObjectWithFloatArray() throws Exception {
        ObjectWithFloatArray obj = Playdoh.build(ObjectWithFloatArray.class);
        assertNotNull(obj);
        assertTrue(obj.getPrimitiveArray().length > 0);
        assertTrue(obj.getWrapperArray().length > 0);
    }

    @Test
    public void testGenerateObjectWithIntArray() throws Exception {
        ObjectWithIntArray obj = Playdoh.build(ObjectWithIntArray.class);
        assertNotNull(obj);
        assertTrue(obj.getPrimitiveArray().length > 0);
        assertTrue(obj.getWrapperArray().length > 0);
    }

    @Test
    public void testGenerateObjectWithLongArray() throws Exception {
        ObjectWithLongArray obj = Playdoh.build(ObjectWithLongArray.class);
        assertNotNull(obj);
        assertTrue(obj.getPrimitiveArray().length > 0);
        assertTrue(obj.getWrapperArray().length > 0);
    }

    @Test
    public void testGenerateObjectWithShortArray() throws Exception {
        ObjectWithShortArray obj = Playdoh.build(ObjectWithShortArray.class);
        assertNotNull(obj);
        assertTrue(obj.getPrimitiveArray().length > 0);
        assertTrue(obj.getWrapperArray().length > 0);
    }

}