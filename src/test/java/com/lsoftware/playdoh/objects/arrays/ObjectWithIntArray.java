package com.lsoftware.playdoh.objects.arrays;

public class ObjectWithIntArray {

    private int[] primitiveArray;

    private Integer[] wrapperArray;

    public ObjectWithIntArray(){
    }

    public int[] getPrimitiveArray() {
        return primitiveArray;
    }

    public void setPrimitiveArray(int[] primitiveArray) {
        this.primitiveArray = primitiveArray;
    }

    public Integer[] getWrapperArray() {
        return wrapperArray;
    }

    public void setWrapperArray(Integer[] wrapperArray) {
        this.wrapperArray = wrapperArray;
    }
}
