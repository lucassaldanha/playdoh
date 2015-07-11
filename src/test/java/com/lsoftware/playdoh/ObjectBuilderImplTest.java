package com.lsoftware.playdoh;

import com.lsoftware.playdoh.objects.models.*;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ObjectBuilderImplTest {

    @Test
    public void testCreateObjectWithPublicAccessorMethodsShouldSucceed() throws Exception {
        OnlyPublicFields obj = Playdoh.build(OnlyPublicFields.class);
        assertNotNull(obj);
        assertNotNull(obj.getS());
        assertNotNull(obj.getI());
    }

    @Test
    public void testCreateObjectWithProtectedAccessorMethodsShouldFail() throws Exception {
        OnlyProtectedFields obj = Playdoh.build(OnlyProtectedFields.class);
        assertNotNull(obj);
    }

    @Test
    public void testCreateObjectWithPackageAccessorMethodsShouldFail() throws Exception {
        OnlyPackageFields obj = Playdoh.build(OnlyPackageFields.class);
        assertNotNull(obj);
    }

    @Test
    public void testCreateObjectWithPrivateAccessorMethodsShouldFail() throws Exception {
        OnlyPrivateFields obj = Playdoh.build(OnlyPrivateFields.class);
        assertNotNull(obj);
    }

    @Test
    public void testCreateObjectWithPrivateConstructorShouldFail() throws Exception {
        Playdoh.build(OnlyPrivateConstructor.class);
    }

}