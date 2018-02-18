package com.lsoftware.playdoh.objects.models;

public class ClassWithoutSetter {

    private String field;

    private String anotherField;

    public ClassWithoutSetter() {
    }

    public String getAnotherField() {
        return anotherField;
    }

    public void setAnotherField(String anotherField) {
        this.anotherField = anotherField;
    }

    public String getField() {
        return field;
    }


}
