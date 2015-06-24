package com.lsoftware.testobjectfactory.generator;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;

@SuppressWarnings("unchecked")
public abstract class AbstractGenerator<T> implements TypeValueGenerator<T> {

    private int DEFAULT_ARRAY_SIZE = 10;

    private Class<T> type;

    public AbstractGenerator() {
        type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public abstract T generate();

    @Override
    public <T> T[] generateArray() {
        T[] array = (T[]) Array.newInstance(type, DEFAULT_ARRAY_SIZE);

        for (int i = 0; i < DEFAULT_ARRAY_SIZE; i++) {
            array[i] = (T) generate();
        }

        return array;
    }
}
