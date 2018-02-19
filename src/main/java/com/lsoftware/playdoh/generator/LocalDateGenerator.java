package com.lsoftware.playdoh.generator;

import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;

public class LocalDateGenerator extends AbstractGenerator<LocalDate> {

    private static final long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
    private static final long maxDay = LocalDate.of(2200, 12, 31).toEpochDay();

    public LocalDate generate() {
        return LocalDate.ofEpochDay(RandomUtils.nextLong(minDay,maxDay));
    }
}
