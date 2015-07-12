package com.lsoftware.playdoh;

import java.util.List;

public interface FixtureObjectBuilder {

    <T> T build(Class type);

    <T> T build(Class type, String id);

    <T> List<T> buildAll(Class type);

}
