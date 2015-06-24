package com.lsoftware.testobjectfactory.generator;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ShortGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        short generated = new ShortGenerator().generate();
        assertNotNull(generated);
    }
}