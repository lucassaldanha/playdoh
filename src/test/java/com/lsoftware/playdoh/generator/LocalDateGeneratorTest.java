package com.lsoftware.playdoh.generator;

import org.junit.Test;

import java.time.LocalDate;

import static junit.framework.TestCase.assertNotNull;

public class LocalDateGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        LocalDate generated = new LocalDateGenerator().generate();
        assertNotNull(generated);
    }

    @Test
    public void testGenerateArray() throws Exception {
        final LocalDate[] localDates = new LocalDateGenerator().generateArray();

        assertNotNull(localDates);
    }
}