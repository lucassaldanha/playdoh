package com.lsoftware.playdoh.generator;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class IntegerGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        int generated = new IntegerGenerator().generate();
        assertNotNull(generated);
    }

    @Test
    public void testGenerateArray() throws Exception {
        final Integer[] integers = new IntegerGenerator().generateArray();

        assertNotNull(integers);
    }
}