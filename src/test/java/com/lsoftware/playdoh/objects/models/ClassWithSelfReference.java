package com.lsoftware.playdoh.objects.models;

public class ClassWithSelfReference {

    private ClassWithSelfReference self;

    public ClassWithSelfReference() {
    }

    public ClassWithSelfReference getSelf() {
        return self;
    }

    public void setSelf(ClassWithSelfReference self) {
        this.self = self;
    }
}
