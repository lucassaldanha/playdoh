package com.lsoftware.testobjectfactory.generator;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class StringGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        String generated = new StringGenerator().generate();
        assertNotNull(generated);
    }
}