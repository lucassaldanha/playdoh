package com.lsoftware.playdoh.generator;

public interface TypeValueGenerator<T> {

    T generate();

    <T> T[] generateArray();

}
