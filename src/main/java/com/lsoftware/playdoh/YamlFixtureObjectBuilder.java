package com.lsoftware.playdoh;

import com.lsoftware.playdoh.reader.YamlModelReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YamlFixtureObjectBuilder extends AbstractFixtureObjectBuilder {

    protected YamlFixtureObjectBuilder() {
        super(new YamlModelReader());
    }

    @Override @SuppressWarnings("unchecked")
    public <T> T doBuild(Class type) {
        Map objects = reader.read(type);
        Map.Entry entry = (Map.Entry) objects.entrySet().iterator().next();
        return (T) entry.getValue();
    }

    @Override
    public <T> T doBuild(Class type, String id) {
        return (T) reader.read(id, type);
    }

    @Override
    public <T> List<T> doBuildAll(Class type) {
        Map objects = reader.read(type);
        return new ArrayList<T>(objects.values());
    }
}
