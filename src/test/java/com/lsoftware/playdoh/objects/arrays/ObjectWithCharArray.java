package com.lsoftware.playdoh.objects.arrays;

public class ObjectWithCharArray {

    private char[] primitiveArray;

    private Character[] wrapperArray;

    public ObjectWithCharArray(){
    }

    public char[] getPrimitiveArray() {
        return primitiveArray;
    }

    public void setPrimitiveArray(char[] primitiveArray) {
        this.primitiveArray = primitiveArray;
    }

    public Character[] getWrapperArray() {
        return wrapperArray;
    }

    public void setWrapperArray(Character[] wrapperArray) {
        this.wrapperArray = wrapperArray;
    }
}
