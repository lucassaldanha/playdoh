package com.lsoftware.testobjectfactory.generator;

public interface TypeValueGenerator<T> {

    T generate();

    <T> T[] generateArray();

}
