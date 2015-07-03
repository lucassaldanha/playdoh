package com.lsoftware.playdoh.resolver;

public interface InterfaceMapper<I> {

    boolean apply(Class type);

    Class getConcreteType(Class<I> type);

}
