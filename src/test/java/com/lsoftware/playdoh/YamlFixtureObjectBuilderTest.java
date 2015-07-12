package com.lsoftware.playdoh;

import com.lsoftware.playdoh.objects.models.User;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class YamlFixtureObjectBuilderTest {

    private YamlFixtureObjectBuilder builder = new YamlFixtureObjectBuilder();

    @Test
    public void testBuildUserObjectFromFixture() throws FileNotFoundException {
        User user = builder.build(User.class, "aUser");
        assertEquals("Lucas Saldanha", user.getName());
        assertEquals("lucas@example.com", user.getEmail());
        assertEquals(123, user.getAge());
    }

    @Test
    public void testBuildFirstUserFromCollectionFromFixture() throws FileNotFoundException {
        User user = builder.build(User.class);
        assertEquals("Lucas Saldanha", user.getName());
        assertEquals("lucas@example.com", user.getEmail());
        assertEquals(123, user.getAge());
    }

    @Test
    public void testBuildCollectionFromFixture() throws FileNotFoundException {
        List<User> users = builder.buildAll(User.class);
        assertEquals(2, users.size());
    }

}
