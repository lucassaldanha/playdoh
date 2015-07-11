package com.lsoftware.playdoh.objects.arrays;

public class ObjectWithLongArray {

    private long[] primitiveArray;

    private Long[] wrapperArray;

    public ObjectWithLongArray(){
    }

    public long[] getPrimitiveArray() {
        return primitiveArray;
    }

    public void setPrimitiveArray(long[] primitiveArray) {
        this.primitiveArray = primitiveArray;
    }

    public Long[] getWrapperArray() {
        return wrapperArray;
    }

    public void setWrapperArray(Long[] wrapperArray) {
        this.wrapperArray = wrapperArray;
    }
}
