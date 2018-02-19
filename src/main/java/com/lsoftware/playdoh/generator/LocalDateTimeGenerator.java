package com.lsoftware.playdoh.generator;

import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.ZoneOffset.MIN;

public class LocalDateTimeGenerator extends AbstractGenerator<LocalDateTime> {

    private static final long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
    private static final long maxDay = LocalDate.of(2200, 12, 31).toEpochDay();
    private static final int maxNanoOfSecond = 999999999;

    public LocalDateTime generate() {
        return LocalDateTime.ofEpochSecond(RandomUtils.nextLong(minDay,maxDay),RandomUtils.nextInt(0,maxNanoOfSecond),MIN);
    }
}
