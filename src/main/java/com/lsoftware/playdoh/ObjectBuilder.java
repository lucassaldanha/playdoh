package com.lsoftware.playdoh;

public interface ObjectBuilder {

    <T> T build();

    ObjectBuilder with(String name, Object value);

}
