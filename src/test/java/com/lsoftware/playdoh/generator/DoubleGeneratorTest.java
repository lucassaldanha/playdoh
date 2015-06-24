package com.lsoftware.playdoh.generator;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DoubleGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        double generated = new DoubleGenerator().generate();
        assertNotNull(generated);
    }
}