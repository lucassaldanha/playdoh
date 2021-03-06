package com.lsoftware.playdoh;

import com.lsoftware.playdoh.objects.collections.ObjectWithArray;
import com.lsoftware.playdoh.objects.collections.ObjectWithCollection;
import com.lsoftware.playdoh.objects.collections.ObjectWithStringObjectMap;
import com.lsoftware.playdoh.objects.models.*;
import com.lsoftware.playdoh.objects.models.ClassWithoutDefaultConstructor;
import com.lsoftware.playdoh.objects.models.ClassWithoutSetter;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaydohRandomDataObjectBuilder {

    @Test
    public void testBuildDummyObject() throws Exception {
        final Dummy builtDummy = Playdoh.build(Dummy.class);
        assertNotNull(builtDummy);
        assertNotNull(builtDummy.getIntegerValue());
        assertNotNull(builtDummy.getStringValue());

        final NestedDummy nestedDummy = builtDummy.getNestedDummy();
        assertNotNull(nestedDummy);
        assertNotNull(nestedDummy.getIntValue());
        assertNotNull(nestedDummy.getStringValue());
    }

    @Test
    public void testBuildParentObject() {
        final ParentObject builtParent = Playdoh.build(ParentObject.class);
        assertNotNull(builtParent.getParentString());
    }

    @Test
    public void testBuildInheritanceObject() {
        final InheritanceObject builtInheritance = Playdoh.build(InheritanceObject.class);
        assertNotNull(builtInheritance.getInheritanceString());
        assertNotNull(builtInheritance.getParentString());
    }

    @Test
    public void testBuildObjectWithArray() {
        final ObjectWithArray objectWithArray = Playdoh.build(ObjectWithArray.class);
        assertNotNull(objectWithArray);
        assertTrue(objectWithArray.getIntArray().length > 0);
    }

    @Test
    public void testBuildObjectWithPrimitiveArray() {
        final ObjectWithPrimitiveArray objectWithPrimitiveArray = Playdoh.build(ObjectWithPrimitiveArray.class);
        assertNotNull(objectWithPrimitiveArray);
        assertTrue(objectWithPrimitiveArray.getIntArray().length > 0);
    }

    @Test
    public void testBuildObjectWithEnum() {
        final ObjectWithEnum objectWithEnum = Playdoh.build(ObjectWithEnum.class);
        assertNotNull(objectWithEnum);
    }

    @Test
    public void testBuildObjectWithMap() {
        ObjectWithStringObjectMap objectWithMap = Playdoh.build(ObjectWithStringObjectMap.class);
        assertNotNull(objectWithMap);
        assertEquals(0, objectWithMap.getMap().size());
    }

    @Test
    public void testBuildObjectWithCollection() {
        ObjectWithCollection objectWithCollection = Playdoh.build(ObjectWithCollection.class);
        assertNotNull(objectWithCollection);
        assertEquals(0, objectWithCollection.getCollection().size());
    }

    @Test
    public void testBuildObjectWithInaccessibleFieldsShouldSucceed() {
        ObjectWithInaccessibleFields object = Playdoh.build(ObjectWithInaccessibleFields.class);
        assertNotNull(object);
    }

    @Test
    public void testBuildObjectWithSelfReferenceShouldSucceed() {
        ClassWithSelfReference object = Playdoh.build(ClassWithSelfReference.class);
        assertNotNull(object);
    }

    @Test
    public void testBuildObjectWithNoSetterShouldSucceedWithNoValueForField(){
        ClassWithoutSetter object = Playdoh.build(ClassWithoutSetter.class);
        assertNotNull(object);
        assertNull(object.getField());
        assertNotNull(object.getAnotherField());
    }

    @Test
    public void testBuildObjectWithNoDefaultConstructorShouldSucceed(){
        ClassWithoutDefaultConstructor object = Playdoh.build(ClassWithoutDefaultConstructor.class);
        assertNotNull(object);
    }

}
