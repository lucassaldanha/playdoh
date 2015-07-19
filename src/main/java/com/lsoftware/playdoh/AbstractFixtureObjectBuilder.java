package com.lsoftware.playdoh;

import com.lsoftware.playdoh.reader.ModelReader;
import com.lsoftware.playdoh.reader.YamlModelReader;
import com.lsoftware.playdoh.regex.RegexResolver;
import com.lsoftware.playdoh.util.ReflectionUtils;

import java.util.List;

public abstract class AbstractFixtureObjectBuilder implements FixtureObjectBuilder {

    protected ModelReader reader;

    protected AbstractFixtureObjectBuilder(ModelReader modelReader) {
        this.reader = modelReader;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T build(Class type) {
        return doBuild(type);
    }

    @SuppressWarnings("unchecked")
    protected abstract <T> T doBuild(Class type);

    @Override
    public <T> T build(Class type, String id) {
        return doBuild(type, id);
    }

    protected abstract <T> T doBuild(Class type, String id);

    @Override
    public <T> List<T> buildAll(Class type) {
        return doBuildAll(type);
    }

    protected abstract <T> List<T> doBuildAll(Class type);

}
