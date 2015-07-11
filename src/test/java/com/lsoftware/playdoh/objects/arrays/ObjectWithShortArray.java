package com.lsoftware.playdoh.objects.arrays;

public class ObjectWithShortArray {

    private short[] primitiveArray;

    private Short[] wrapperArray;

    public ObjectWithShortArray(){
    }

    public short[] getPrimitiveArray() {
        return primitiveArray;
    }

    public void setPrimitiveArray(short[] primitiveArray) {
        this.primitiveArray = primitiveArray;
    }

    public Short[] getWrapperArray() {
        return wrapperArray;
    }

    public void setWrapperArray(Short[] wrapperArray) {
        this.wrapperArray = wrapperArray;
    }
}
