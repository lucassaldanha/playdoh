package com.lsoftware.playdoh.objects;

public class InheritanceObject extends ParentObject {

    private String inheritanceString;

    public String getInheritanceString() {
        return inheritanceString;
    }

    public void setInheritanceString(String inheritanceString) {
        this.inheritanceString = inheritanceString;
    }

    @Override
    public String toString() {
        return "InheritanceObject{" +
                "inheritanceString='" + inheritanceString + '\'' +
                "parentString='" + getParentString() + '\'' +
                '}';
    }
}
