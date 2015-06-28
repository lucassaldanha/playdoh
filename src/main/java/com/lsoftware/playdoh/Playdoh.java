package com.lsoftware.playdoh;

public final class Playdoh {

    /**
     * Builds an instance of a class with random data
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

    /**
     * Builds an instance of a class with data specified in the yml file with corresponding snake-case name.
     * i.e. For an user class will look for a user.yml file with data.
     * @param type The class to be instanced
     * @param name Tha name of the set of data inside the yml file to be used
     * @return a object with data corresponding the yml fixture file
     */
    public static <T> T build(Class<T> type, String name) {
        return new FixtureObjectBuilder(name, type).build();
    }

}
