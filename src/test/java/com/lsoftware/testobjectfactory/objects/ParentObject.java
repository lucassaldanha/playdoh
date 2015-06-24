package com.lsoftware.testobjectfactory.objects;

public class ParentObject {

    private String parentString;

    public void setParentString(String parentString) {
        this.parentString = parentString;
    }

    public String getParentString() {
        return parentString;
    }

    @Override
    public String toString() {
        return "ParentObject{" +
                "parentString='" + parentString + '\'' +
                '}';
    }
}
