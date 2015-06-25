package com.lsoftware.playdoh;

public class Playdoh {

    /**
     * Builds an instance of the a class with random data
     * @param type The class to be instanced
     * @return a object with random data
     */
    public static <T> T build(Class<T> type) {
        return new ObjectBuilderImpl(type).build();
    }

    /**
     * Create an ObjectBuilder for a object of a specific type.
     * With an ObjectBuilder it is possible to customize the object creation, as setting specific valuesto some fields.
     * @param type the type of the object to be created by the ObjectBuilder
     * @return a ObjectBuilder
     */
    public static <T> ObjectBuilder builder(Class<T> type) {
        return new ObjectBuilderImpl(type);
    }

}
