package com.lsoftware.playdoh.regex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GenerexResolverTest {

    private GenerexResolver regexResolver = new GenerexResolver();

    @Test
    public void testResolveStringRegex() {
        String generatedString = regexResolver.generate("[abcdefghijklmnopqrsyuvwyxz]{10}");
        assertNotNull(generatedString);
        assertEquals(10, generatedString.length());
    }

    @Test
    public void testResolveNumberRegex() {
        String generatedString = regexResolver.generate("\\d{3}");
        assertNotNull(generatedString);
        int generatedNumber = Integer.valueOf(generatedString);
    }

}
