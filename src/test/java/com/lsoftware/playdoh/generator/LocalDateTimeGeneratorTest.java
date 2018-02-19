package com.lsoftware.playdoh.generator;

import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertNotNull;

public class LocalDateTimeGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        LocalDateTime generated = new LocalDateTimeGenerator().generate();
        assertNotNull(generated);
    }

    @Test
    public void testGenerateArray() throws Exception {
        final LocalDateTime[] localDateTimes = new LocalDateTimeGenerator().generateArray();

        assertNotNull(localDateTimes);
    }
}