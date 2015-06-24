package com.lsoftware.playdoh.generator;

import org.apache.commons.lang3.RandomUtils;

public class BooleanGenerator extends AbstractGenerator<Boolean> {

    //TODO parametrize to return fixed boolean value

    public Boolean generate() {
        return RandomUtils.nextInt(0, 2) != 0;
    }
}
