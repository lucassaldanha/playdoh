package com.lsoftware.testobjectfactory.generator;

import org.apache.commons.lang3.RandomUtils;

public class ByteGenerator extends AbstractGenerator<Byte> {

    public Byte generate() {
        return RandomUtils.nextBytes(1)[0];
    }
}
