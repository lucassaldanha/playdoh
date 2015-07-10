package com.lsoftware.playdoh;

import com.lsoftware.playdoh.exception.FixtureNotFoundException;
import com.lsoftware.playdoh.objects.collections.*;
import com.lsoftware.playdoh.objects.models.ClassWithoutFixture;
import com.lsoftware.playdoh.objects.models.Dummy;
import com.lsoftware.playdoh.objects.models.ObjectWithEnum;
import com.lsoftware.playdoh.objects.models.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

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

    @Test
    public void testBuildObjectWithCollectionFromFixture() {
        ObjectWithCollection object = Playdoh.build(ObjectWithCollection.class, "collection1");
        assertNotNull(object);
        assertEquals(3, object.getCollection().size());

        List<String> strings = new ArrayList<String>(object.getCollection());
        assertEquals("string1", strings.get(0));
        assertEquals("string2", strings.get(1));
        assertEquals("string3", strings.get(2));
    }

    @Test
    public void testBuildObjectWithTypedCollectionFromFixture() {
        ObjectWithTypedCollection object = Playdoh.build(ObjectWithTypedCollection.class, "collection1");
        assertNotNull(object);
        assertEquals(3, object.getCollection().size());

        List<String> strings = new ArrayList<String>(object.getCollection());
        assertEquals("string1", strings.get(0));
        assertEquals("string2", strings.get(1));
        assertEquals("string3", strings.get(2));
    }

    @Test
    public void testBuildObjectWithIntegerOfTypedCollectionFromFixture() {
        ObjectWithIntCollection object = Playdoh.build(ObjectWithIntCollection.class, "intCollection");
        assertNotNull(object);
        assertEquals(3, object.getCollection().size());

        List<Integer> integers = new ArrayList<Integer>(object.getCollection());
        assertEquals(1, (int) integers.get(0));
        assertEquals(2, (int) integers.get(1));
        assertEquals(3, (int) integers.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildObjectWithWrongTypeOfTypedCollectionFromFixture() {
        Playdoh.build(ObjectWithIntCollection.class, "stringCollection");
    }

    @Test
    public void testBuildObjectWithSetFromFixture() {
        ObjectWithSet object = Playdoh.build(ObjectWithSet.class, "set1");
        assertNotNull(object);
        assertEquals(3, object.getSet().size());

        Set<String> strings = object.getSet();
        assertTrue(strings.contains("string1"));
        assertTrue(strings.contains("string2"));
        assertTrue(strings.contains("string3"));
    }

    @Test
    public void testBuildObjectWithListFromFixture() {
        ObjectWithList object = Playdoh.build(ObjectWithList.class, "list1");
        assertNotNull(object);
        assertEquals(3, object.getList().size());

        List<String> strings = object.getList();
        assertEquals("string1", strings.get(0));
        assertEquals("string2", strings.get(1));
        assertEquals("string3", strings.get(2));
    }

    @Test
    public void testBuildObjectWithMapFromFixture() {
        ObjectWithMap object = Playdoh.build(ObjectWithMap.class, "map1");
        assertNotNull(object);

        Map map = object.getMap();
        assertEquals(3, map.size());

        assertTrue(map.containsKey("key1"));
        assertTrue(map.containsKey("key2"));
        assertTrue(map.containsKey("key3"));

        assertTrue(map.containsValue("value1"));
        assertTrue(map.containsValue("value2"));
        assertTrue(map.containsValue("value3"));
    }

}
