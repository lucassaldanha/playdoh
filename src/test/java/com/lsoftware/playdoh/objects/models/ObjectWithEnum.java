package com.lsoftware.playdoh.objects.models;

public class ObjectWithEnum {

    private AnEnum anEnum;

    public ObjectWithEnum() {
    }

    public AnEnum getAnEnum() {
        return anEnum;
    }

    public void setAnEnum(AnEnum anEnum) {
        this.anEnum = anEnum;
    }

    public enum AnEnum {
        X, Y
    }
}
