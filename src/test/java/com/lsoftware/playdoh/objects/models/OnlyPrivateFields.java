package com.lsoftware.playdoh.objects.models;

public class OnlyPrivateFields {

    private String s;
    private int i;

    public OnlyPrivateFields(){
    }

    private String getS() {
        return s;
    }

    private void setS(String s) {
        this.s = s;
    }

    private int getI() {
        return i;
    }

    private void setI(int i) {
        this.i = i;
    }
}
