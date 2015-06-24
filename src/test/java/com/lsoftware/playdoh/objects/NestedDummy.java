package com.lsoftware.playdoh.objects;

public class NestedDummy {

    private int intValue;

    private String stringValue;

    NestedDummy(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    NestedDummy(){}

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return "NestedDummy{" +
                "intValue=" + intValue +
                ", stringValue='" + stringValue + '\'' +
                '}';
    }
}
