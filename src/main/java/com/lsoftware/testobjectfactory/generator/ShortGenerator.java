package com.lsoftware.testobjectfactory.generator;

import org.apache.commons.lang3.RandomUtils;

public class ShortGenerator extends AbstractGenerator<Short> {

    //TODO parametrize to allow negative

    public Short generate() {
        return (short) RandomUtils.nextInt(0, Short.MAX_VALUE);
    }
}
