package com.lsoftware.playdoh.generator;

import org.apache.commons.lang3.RandomUtils;

public class IntegerGenerator extends AbstractGenerator<Integer> {

    //TODO parametrize to allow negative numbers

    public Integer generate() {
        return RandomUtils.nextInt(0, Integer.MAX_VALUE);
    }
}
