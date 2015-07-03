package com.lsoftware.playdoh.resolver;

public interface InterfaceMapper {

    boolean apply(Class type);

    Class getConcreteType(Class type);

}
