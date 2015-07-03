package com.lsoftware.playdoh.resolver;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JavaCollectionsMapperTest {

    private final JavaCollectionsMapper interfaceMapper = new JavaCollectionsMapper();

    @Test
    public void testMappingIterableToHashSet() {
        Class interfaceType = Iterable.class;
        assertTrue(interfaceMapper.apply(interfaceType));
        assertEquals(HashSet.class, interfaceMapper.getConcreteType(interfaceType));
    }

    @Test
    public void testMappingCollectionToHashSet() {
        Class type = Collection.class;
        assertTrue(interfaceMapper.apply(type));
        assertEquals(HashSet.class, interfaceMapper.getConcreteType(type));
    }

    @Test
    public void testMappingSetToHashSet() {
        Class type = Set.class;
        assertTrue(interfaceMapper.apply(type));
        assertEquals(HashSet.class, interfaceMapper.getConcreteType(type));
    }

    @Test
    public void testMappingListToLinkedList() {
        Class type = List.class;
        assertTrue(interfaceMapper.apply(type));
        assertEquals(LinkedList.class, interfaceMapper.getConcreteType(type));
    }

    @Test
    public void testMappingQueueToLinkedList() {
        Class type = Queue.class;
        assertTrue(interfaceMapper.apply(type));
        assertEquals(LinkedList.class, interfaceMapper.getConcreteType(type));
    }

    @Test
    public void testMappingDequeToLinkedList() {
        Class type = Deque.class;
        assertTrue(interfaceMapper.apply(type));
        assertEquals(LinkedList.class, interfaceMapper.getConcreteType(type));
    }

    @Test
    public void testMappingMapToHashMap() {
        Class type = Map.class;
        assertTrue(interfaceMapper.apply(type));
        assertEquals(HashMap.class, interfaceMapper.getConcreteType(type));
    }

}