package com.lsoftware.playdoh.generator;

import org.apache.commons.lang3.RandomStringUtils;

public class StringGenerator extends AbstractGenerator<String> {

    private static final int RANDOM_STRING_SIZE = 10;

    public String generate() {
        return RandomStringUtils.randomAlphabetic(RANDOM_STRING_SIZE);
    }
}
