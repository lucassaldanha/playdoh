package com.lsoftware.playdoh.resolver;

import java.util.*;

public abstract class AbstractInterfaceMapper implements InterfaceMapper {

    private Map<Class, Class> classMap = new HashMap<Class, Class>();

    public AbstractInterfaceMapper() {
        classMap = loadMap();
    }

    @Override
    public boolean apply(Class type) {
        return classMap.containsKey(type);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class getConcreteType(Class type) {
        Class concreteClass = classMap.get(type);

        if (!type.isAssignableFrom(concreteClass)) {
            throw new IllegalStateException(String.format("Invalid mapping in %s. Class %s doesn't implements interface %s",
                    getClass().getSimpleName(), concreteClass.getSimpleName(), type.getSimpleName()));
        }

        return concreteClass;
    }

    protected abstract Map<Class, Class> loadMap();

    void setClassMap(Map<Class, Class> classMap) {
        this.classMap = classMap;
    }
}
