package com.lsoftware.playdoh.objects.models;

public class Dummy {

    private Integer integerValue;

    private String stringValue;

    private NestedDummy nestedDummy;

    Dummy(int integerValue, String stringValue, NestedDummy nestedDummy) {
        this.integerValue = integerValue;
        this.stringValue = stringValue;
        this.nestedDummy = nestedDummy;
    }

    public Dummy(){}

    public int getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(int integerValue) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dummy)) return false;

        Dummy dummy = (Dummy) o;

        if (integerValue != null ? !integerValue.equals(dummy.integerValue) : dummy.integerValue != null) return false;
        if (stringValue != null ? !stringValue.equals(dummy.stringValue) : dummy.stringValue != null) return false;
        return !(nestedDummy != null ? !nestedDummy.equals(dummy.nestedDummy) : dummy.nestedDummy != null);

    }

    @Override
    public int hashCode() {
        int result = integerValue != null ? integerValue.hashCode() : 0;
        result = 31 * result + (stringValue != null ? stringValue.hashCode() : 0);
        result = 31 * result + (nestedDummy != null ? nestedDummy.hashCode() : 0);
        return result;
    }
}
