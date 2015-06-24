package com.lsoftware.playdoh;

import com.lsoftware.playdoh.objects.Dummy;

class PlaydohExample {

    public static void main(String[] args) {
        final Dummy dummy = Playdoh.build(Dummy.class);
        System.out.println(dummy);
    }

}
