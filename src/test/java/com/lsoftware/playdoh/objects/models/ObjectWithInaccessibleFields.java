package com.lsoftware.playdoh.objects.models;

import java.io.Serializable;

public class ObjectWithInaccessibleFields implements Serializable {

    private static final long serialVersionUID = 1L;

    private String inaccessible;

    private String accessible;

    public ObjectWithInaccessibleFields() {
    }

    public String getAccessible() {
        return accessible;
    }

    public void setAccessible(String accessible) {
        this.accessible = accessible;
    }
}
