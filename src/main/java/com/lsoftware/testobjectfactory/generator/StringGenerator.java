package com.lsoftware.testobjectfactory.generator;

import org.apache.commons.lang3.RandomStringUtils;

public class StringGenerator extends AbstractGenerator<String> {

    public static final int RANDOM_STRING_SIZE = 10;

    public String generate() {
        return RandomStringUtils.randomAlphabetic(RANDOM_STRING_SIZE);
    }
}
