package com.lsoftware.playdoh;

import com.lsoftware.playdoh.objects.Dummy;
import com.lsoftware.playdoh.objects.User;

class PlaydohExample {

    public static void main(String[] args) {
        /*
            Creating Dummy instance with random data
         */
        final Dummy dummy = Playdoh.build(Dummy.class);
        System.out.println(dummy);

        /*
            Look the user.yml file to see the data specification
         */
        final User user = Playdoh.build(User.class, "aUser");
        System.out.println(user);
    }

}
