package com.lsoftware.testobjectfactory.generator;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class BooleanGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        boolean generated = new BooleanGenerator().generate();
        assertNotNull(generated);
    }
}