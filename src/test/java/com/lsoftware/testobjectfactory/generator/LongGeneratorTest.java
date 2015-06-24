package com.lsoftware.testobjectfactory.generator;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LongGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        float generated = new LongGenerator().generate();
        assertNotNull(generated);
    }
}