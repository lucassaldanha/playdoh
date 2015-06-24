package com.lsoftware.playdoh;

import com.lsoftware.playdoh.objects.Dummy;

class ObjectBuilderExample {

    public static void main(String[] args) {
        final Dummy dummy = ObjectBuilder.getInstance().build(Dummy.class);
        System.out.println(dummy);
    }

}
