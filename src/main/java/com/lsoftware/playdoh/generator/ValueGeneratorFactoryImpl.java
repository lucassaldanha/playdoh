package com.lsoftware.playdoh.generator;

import com.lsoftware.playdoh.util.Primitives;

import java.util.HashMap;
import java.util.Map;

public class ValueGeneratorFactoryImpl implements ValueGeneratorFactory {

    private final Map<Class, TypeValueGenerator> generators = new HashMap<Class, TypeValueGenerator>(){{
        put(    Byte.class,         new ByteGenerator());
        put(    Short.class,        new ShortGenerator());
        put(    Integer.class,      new IntegerGenerator());
        put(    Long.class,         new LongGenerator());
        put(    Float.class,        new FloatGenerator());
        put(    Double.class,       new DoubleGenerator());
        put(    Boolean.class,      new BooleanGenerator());
        put(    Character.class,    new CharacterGenerator());
        put(    String.class,       new StringGenerator());
    }};

    public TypeValueGenerator getFromType(Class type) {
        if(Primitives.isPrimitive(type) || Primitives.isPrimitiveArray(type)) {
            type = Primitives.getWrapper(type);
        }

        if(type.isArray()) {
            type = type.getComponentType();
        }

        return generators.get(type);
    }

    public boolean existsForType(Class type) {
        if(Primitives.isPrimitive(type) || Primitives.isPrimitiveArray(type)) {
            type = Primitives.getWrapper(type);
        }

        if(type.isArray()) {
            return existsForType(type.getComponentType());
        }

        return generators.containsKey(type);
    }

    public void register(Class type, TypeValueGenerator generator) {
        generators.put(type, generator);
    }
}
