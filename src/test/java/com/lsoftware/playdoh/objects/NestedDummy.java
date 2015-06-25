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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NestedDummy)) return false;

        NestedDummy that = (NestedDummy) o;

        if (intValue != that.intValue) return false;
        return !(stringValue != null ? !stringValue.equals(that.stringValue) : that.stringValue != null);

    }

    @Override
    public int hashCode() {
        int result = intValue;
        result = 31 * result + (stringValue != null ? stringValue.hashCode() : 0);
        return result;
    }
}
