package com.lsoftware.playdoh.generator;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class FloatGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        float generated = new FloatGenerator().generate();
        assertNotNull(generated);
    }
}