package com.lsoftware.playdoh.resolver;

import java.util.LinkedList;
import java.util.List;

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

    public void addMapper(InterfaceMapper mapper) {
        mappers.add(mapper);
    }

    List<InterfaceMapper> getMappers() {
        return mappers;
    }
}
