package com.lsoftware.playdoh.generator;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ByteGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        byte generated = new ByteGenerator().generate();
        assertNotNull(generated);
    }
}