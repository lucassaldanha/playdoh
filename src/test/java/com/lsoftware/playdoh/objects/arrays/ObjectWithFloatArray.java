package com.lsoftware.playdoh.objects.arrays;

public class ObjectWithFloatArray {

    private float[] primitiveArray;

    private Long[] wrapperArray;

    public ObjectWithFloatArray(){
    }

    public float[] getPrimitiveArray() {
        return primitiveArray;
    }

    public void setPrimitiveArray(float[] primitiveArray) {
        this.primitiveArray = primitiveArray;
    }

    public Long[] getWrapperArray() {
        return wrapperArray;
    }

    public void setWrapperArray(Long[] wrapperArray) {
        this.wrapperArray = wrapperArray;
    }
}
