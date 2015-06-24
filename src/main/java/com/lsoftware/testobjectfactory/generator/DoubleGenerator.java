package com.lsoftware.testobjectfactory.generator;

import org.apache.commons.lang3.RandomUtils;

public class DoubleGenerator extends AbstractGenerator<Double> {

    //TODO parametrize to allow setting interval or negative/positive only numbers

    public Double generate() {
        return RandomUtils.nextDouble(Double.MIN_VALUE, Double.MAX_VALUE);
    }
}
