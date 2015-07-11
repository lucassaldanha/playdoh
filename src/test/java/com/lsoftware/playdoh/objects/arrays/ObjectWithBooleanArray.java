package com.lsoftware.playdoh.objects.arrays;

public class ObjectWithBooleanArray {

    private boolean[] primitiveArray;

    private Boolean[] wrapperArray;

    public ObjectWithBooleanArray(){
    }

    public boolean[] getPrimitiveArray() {
        return primitiveArray;
    }

    public void setPrimitiveArray(boolean[] primitiveArray) {
        this.primitiveArray = primitiveArray;
    }

    public Boolean[] getWrapperArray() {
        return wrapperArray;
    }

    public void setWrapperArray(Boolean[] wrapperArray) {
        this.wrapperArray = wrapperArray;
    }
}
