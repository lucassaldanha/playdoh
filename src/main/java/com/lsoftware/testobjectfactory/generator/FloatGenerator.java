package com.lsoftware.testobjectfactory.generator;

import org.apache.commons.lang3.RandomUtils;

public class FloatGenerator extends AbstractGenerator<Float> {

    //TODO parametrize to allow setting interval or negative/positive only numbers

    public Float generate() {
        return RandomUtils.nextFloat(Float.MIN_VALUE, Float.MAX_VALUE);
    }
}
