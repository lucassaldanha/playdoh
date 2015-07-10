package com.lsoftware.playdoh.objects.models;

public class OnlyPrivateConstructor {

    private String s;
    private int i;

    private OnlyPrivateConstructor(){
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
