package com.lsoftware.testobjectfactory.generator;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CharacterGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        char generated = new CharacterGenerator().generate();
        assertNotNull(generated);
    }
}