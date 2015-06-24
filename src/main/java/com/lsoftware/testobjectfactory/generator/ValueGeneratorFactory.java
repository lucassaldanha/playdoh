package com.lsoftware.testobjectfactory.generator;

public interface ValueGeneratorFactory {

    TypeValueGenerator getFromType(Class type);

    boolean existsForType(Class type);

    void register(Class type, TypeValueGenerator generator);

}
