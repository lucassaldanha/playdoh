package com.lsoftware.playdoh.objects.arrays;

public class ObjectWithByteArray {

    private byte[] primitiveArray;
    private Byte[] wrapperArray;

    public ObjectWithByteArray(){
    }

    public byte[] getPrimitiveArray() {
        return primitiveArray;
    }

    public void setPrimitiveArray(byte[] primitiveArray) {
        this.primitiveArray = primitiveArray;
    }

    public Byte[] getWrapperArray() {
        return wrapperArray;
    }

    public void setWrapperArray(Byte[] wrapperArray) {
        this.wrapperArray = wrapperArray;
    }
}
