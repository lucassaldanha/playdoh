package com.lsoftware.playdoh;

import com.lsoftware.playdoh.objects.models.*;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ObjectBuilderImplTest {

    @Test
    public void testCrateObjectWithPublicAccessorMethodsShouldSucceed() throws Exception {
        OnlyPublicFields obj = Playdoh.build(OnlyPublicFields.class);
        assertNotNull(obj);
        assertNotNull(obj.getS());
        assertNotNull(obj.getI());
    }

    @Test
    public void testCrateObjectWithProtectedAccessorMethodsShouldFail() throws Exception {
        OnlyProtectedFields obj = Playdoh.build(OnlyProtectedFields.class);
        assertNotNull(obj);
    }

    @Test
    public void testCrateObjectWithPackageAccessorMethodsShouldFail() throws Exception {
        OnlyPackageFields obj = Playdoh.build(OnlyPackageFields.class);
        assertNotNull(obj);
    }

    @Test
    public void testCrateObjectWithPrivateAccessorMethodsShouldFail() throws Exception {
        OnlyPrivateFields obj = Playdoh.build(OnlyPrivateFields.class);
        assertNotNull(obj);
    }

    @Test
    public void testCrateObjectWithPrivateConstructorShouldFail() throws Exception {
        Playdoh.build(OnlyPrivateConstructor.class);
    }

}