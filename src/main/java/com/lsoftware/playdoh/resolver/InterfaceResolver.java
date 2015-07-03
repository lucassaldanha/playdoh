package com.lsoftware.playdoh.resolver;

public interface InterfaceResolver {

    Class concreteType(Class interfaceType);

    <T> T populate(Class<T> concreteType);
}
