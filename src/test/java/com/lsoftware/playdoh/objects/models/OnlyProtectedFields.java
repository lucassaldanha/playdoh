package com.lsoftware.playdoh.objects.models;

public class OnlyProtectedFields {

    private String s;
    private int i;

    public OnlyProtectedFields(){
    }

    protected String getS() {
        return s;
    }

    protected void setS(String s) {
        this.s = s;
    }

    protected int getI() {
        return i;
    }

    protected void setI(int i) {
        this.i = i;
    }
}
