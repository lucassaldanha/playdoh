package com.lsoftware.playdoh.resolver;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AbstractInterfaceMapperTest {

    private AbstractInterfaceMapper mapper = new JavaCollectionsMapper();

    @Test(expected = IllegalStateException.class)
    public void testGetConcreteTypeToInvalidConcreteClassForInterfaceShouldThrowError() {
        mapper.setClassMap(new HashMap<Class, Class>() {{
            put(Collection.class, Map.class);
        }});

        mapper.getConcreteType(Collection.class);
    }

}