package com.lsoftware.playdoh.objects;

import java.util.Collection;

public class ObjectWithTypedCollection {

    private Collection<String> collection;

    public ObjectWithTypedCollection() {}

    public Collection<String> getCollection() {
        return collection;
    }

    public void setCollection(Collection<String> collection) {
        this.collection = collection;
    }
}
