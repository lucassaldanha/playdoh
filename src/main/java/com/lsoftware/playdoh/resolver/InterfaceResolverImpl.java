package com.lsoftware.playdoh.resolver;

import java.util.*;

public class InterfaceResolverImpl implements InterfaceResolver {

    private List<InterfaceMapper> mappers = new LinkedList<InterfaceMapper>();

    public InterfaceResolverImpl() {
        loadDefaultMappers();
    }

    private void loadDefaultMappers() {
        mappers.add(new JavaCollectionsMapper());
    }

    @Override
    public Class concreteType(Class interfaceType) {
        for (InterfaceMapper mapper : mappers) {
            if(mapper.apply(interfaceType)) {
                return mapper.getConcreteType(interfaceType);
            }
        }

        throw new IllegalStateException("Unable to find a interface mapper for " + interfaceType.getSimpleName() + " type");
    }

    @Override
    public <T> T populate(Class<T> concreteType) {
        /*
            Populate method doesn't populate fields yet (eg. Collections and Maps)
         */
        try {
            return concreteType.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Error creating instance of type " + concreteType.getSimpleName());
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Error creating instance of type " + concreteType.getSimpleName());
        }
    }

    public void addMapper(InterfaceMapper mapper) {
        mappers.add(mapper);
    }

    List<InterfaceMapper> getMappers() {
        return mappers;
    }
}
