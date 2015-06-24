package com.lsoftware.playdoh.objects;

public class Dummy {

    private Integer integerValue;

    private String stringValue;

    private NestedDummy nestedDummy;

    Dummy(int integerValue, String stringValue, NestedDummy nestedDummy) {
        this.integerValue = integerValue;
        this.stringValue = stringValue;
        this.nestedDummy = nestedDummy;
    }

    Dummy(){}

    public int getIntegerValue() {
        return integerValue;
    }

    void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public NestedDummy getNestedDummy() {
        return nestedDummy;
    }

    public void setNestedDummy(NestedDummy nestedDummy) {
        this.nestedDummy = nestedDummy;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "integerValue=" + integerValue +
                ", stringValue='" + stringValue + '\'' +
                ", nested=" + nestedDummy +
                '}';
    }
}
