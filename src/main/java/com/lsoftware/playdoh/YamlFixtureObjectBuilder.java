package com.lsoftware.playdoh;

import com.lsoftware.playdoh.reader.ModelReader;
import com.lsoftware.playdoh.reader.YamlModelReader;

import java.util.*;

public class YamlFixtureObjectBuilder implements FixtureObjectBuilder {

    private ModelReader reader = new YamlModelReader();

    @SuppressWarnings("unchecked")
    public <T> T build(Class type) {
        Map objects = reader.read(type);
        Map.Entry entry = (Map.Entry) objects.entrySet().iterator().next();
        return (T) entry.getValue();
    }

    @Override
    public <T> T build(Class type, String id) {
        return (T) reader.read(id, type);
    }

    @Override
    public <T> List<T> buildAll(Class type) {
        Map objects = reader.read(type);
        return new ArrayList<T>(objects.values());
    }
}
