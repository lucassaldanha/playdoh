package com.lsoftware.playdoh.objects.arrays;

public class ObjectWithDoubleArray {

    private double[] primitiveArray;

    private Double[] wrapperArray;

    public ObjectWithDoubleArray(){
    }

    public double[] getPrimitiveArray() {
        return primitiveArray;
    }

    public void setPrimitiveArray(double[] primitiveArray) {
        this.primitiveArray = primitiveArray;
    }

    public Double[] getWrapperArray() {
        return wrapperArray;
    }

    public void setWrapperArray(Double[] wrapperArray) {
        this.wrapperArray = wrapperArray;
    }
}
