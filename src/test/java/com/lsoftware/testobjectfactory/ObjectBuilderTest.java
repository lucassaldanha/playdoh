package com.lsoftware.testobjectfactory;

import com.lsoftware.testobjectfactory.objects.*;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ObjectBuilderTest {

    private final ObjectBuilder objBuilder = ObjectBuilder.getInstance();

    @Test
    public void testBuildDummyObject() throws Exception {
        final Dummy builtDummy = ObjectBuilder.getInstance().build(Dummy.class);
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
        final ParentObject builtParent = objBuilder.build(ParentObject.class);
        assertNotNull(builtParent.getParentString());
    }

    @Test
    public void testBuildInheritanceObject() {
        final InheritanceObject builtInheritance = objBuilder.build(InheritanceObject.class);
        assertNotNull(builtInheritance.getInheritanceString());
        assertNotNull(builtInheritance.getParentString());
    }

    @Test
    public void testBuildObjectWithArray() {
        final ObjectWithArray objectWithArray = objBuilder.build(ObjectWithArray.class);
        assertNotNull(objectWithArray);
        assertTrue(objectWithArray.getIntArray().length > 0);
    }

    @Test
    public void testBuildObjectWithPrimitiveArray() {
        final ObjectWithPrimitiveArray objectWithPrimitiveArray = objBuilder.build(ObjectWithPrimitiveArray.class);
        assertNotNull(objectWithPrimitiveArray);
        assertTrue(objectWithPrimitiveArray.getIntArray().length > 0);
    }

    @Test
    public void testBuildObjectWithEnum() {
        final ObjectWithEnum objectWithEnum = objBuilder.build(ObjectWithEnum.class);
        assertNotNull(objectWithEnum);
    }
}