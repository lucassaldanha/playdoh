package com.lsoftware.playdoh;

import com.lsoftware.playdoh.objects.User;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class FixtureObjectBuilderTest {

    @Test
    public void testBuildUserObjectFromFixture() throws FileNotFoundException {
        FixtureObjectBuilder builder = new FixtureObjectBuilder("aUser", User.class);
        User user = builder.build();
        assertEquals("Lucas Saldanha", user.getName());
        assertEquals("lucas@example.com", user.getEmail());
        assertEquals(123, user.getAge());
    }

    @Test
    public void testBuildFirstUserFromCollectionFromFixture() throws FileNotFoundException {
        FixtureObjectBuilder builder = new FixtureObjectBuilder(User.class);
        User user = builder.build();
        assertEquals("Lucas Saldanha", user.getName());
        assertEquals("lucas@example.com", user.getEmail());
        assertEquals(123, user.getAge());
    }
}