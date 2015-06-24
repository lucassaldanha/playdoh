package com.lsoftware.testobjectfactory.generator;

import org.apache.commons.lang3.RandomUtils;

public class LongGenerator extends AbstractGenerator<Long> {

    //TODO parametrize to allow negative numbers

    public Long generate() {
        return RandomUtils.nextLong(0, Long.MAX_VALUE);
    }
}
