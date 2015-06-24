package com.lsoftware.testobjectfactory;

import com.lsoftware.testobjectfactory.objects.Dummy;

public class ObjectBuilderExample {

    public static void main(String[] args) {
        final Dummy dummy = ObjectBuilder.getInstance().build(Dummy.class);
        System.out.println(dummy);
    }

}
