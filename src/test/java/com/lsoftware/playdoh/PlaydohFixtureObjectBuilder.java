package com.lsoftware.playdoh;

import com.lsoftware.playdoh.exception.FixtureNotFoundException;
import com.lsoftware.playdoh.objects.ClassWithoutFixture;
import com.lsoftware.playdoh.objects.Dummy;
import com.lsoftware.playdoh.objects.ObjectWithEnum;
import com.lsoftware.playdoh.objects.User;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlaydohFixtureObjectBuilder {

    @Test
    public void testBuildObjectFromFixture() {
        User user1 = Playdoh.build(User.class, "aUser");
        assertNotNull(user1);
        assertEquals("Lucas Saldanha", user1.getName());
        assertEquals("lucas@example.com", user1.getEmail());
        assertEquals(123, user1.getAge());
    }

    @Test
    public void testBuildOtherObjectFromFixture() {
        User user1 = Playdoh.build(User.class, "anotherUser");
        assertNotNull(user1);
        assertEquals("Abdi Abidu", user1.getName());
        assertEquals("aa@example.com", user1.getEmail());
        assertEquals(999, user1.getAge());
    }

    @Test
    public void testBuildNestedObjectFromFixture() {
        Dummy dummy = Playdoh.build(Dummy.class, "dummy1");
        assertNotNull(dummy);
        assertNotNull(dummy.getNestedDummy());

        assertEquals(123, dummy.getIntegerValue());
        assertEquals("abc", dummy.getStringValue());
        assertEquals(321, dummy.getNestedDummy().getIntValue());
        assertEquals("xyz", dummy.getNestedDummy().getStringValue());
    }

    @Test
    public void testBuildObjectWithEnumFromFixture() {
        ObjectWithEnum objectWithEnum = Playdoh.build(ObjectWithEnum.class, "objectWithEnum");
        assertNotNull(objectWithEnum);
        assertEquals(ObjectWithEnum.AnEnum.X, objectWithEnum.getAnEnum());
    }

    @Test(expected = FixtureNotFoundException.class)
    public void testBuildObjectFromAbsentFixture() {
        Playdoh.build(ClassWithoutFixture.class, "aClass");
    }

    /*
        Testing FixtureObjectBuilder directly
     */

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
