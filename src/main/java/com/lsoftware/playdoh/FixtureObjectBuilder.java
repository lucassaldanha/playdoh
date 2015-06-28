package com.lsoftware.playdoh;

import com.lsoftware.playdoh.reader.ModelReader;
import com.lsoftware.playdoh.reader.YamlModelReader;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class FixtureObjectBuilder {

    // yaml reader is the default... maybe later we can add more options
    private ModelReader reader = new YamlModelReader();

    private String identifier;
    private Class type;

    public <T> FixtureObjectBuilder(Class<T> type) {
        this.type = type;
    }

    public <T> FixtureObjectBuilder(String identifier, Class<T> type) {
        this.identifier = identifier;
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    protected <T> T build() {
        if(StringUtils.isBlank(identifier)) {
            Map objects = reader.read(type);
            Map.Entry entry = (Map.Entry) objects.entrySet().iterator().next();
            return (T) entry.getValue();
        } else {
            return (T) reader.read(identifier, type);
        }
    }

}
