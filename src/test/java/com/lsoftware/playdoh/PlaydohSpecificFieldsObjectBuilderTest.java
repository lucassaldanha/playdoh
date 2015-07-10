package com.lsoftware.playdoh;

import com.lsoftware.playdoh.objects.models.Dummy;
import com.lsoftware.playdoh.objects.models.NestedDummy;
import com.lsoftware.playdoh.objects.models.ObjectWithInaccessibleFields;
import com.lsoftware.playdoh.objects.models.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaydohSpecificFieldsObjectBuilderTest {

    @Test
    public void testBuildObjectWithSpecificValueOnField() {
        Dummy dummy = Playdoh.builder(Dummy.class)
                .with("stringValue", "test")
                .with("integerValue", 123)
                .build();

        assertEquals("test", dummy.getStringValue());
        assertEquals(123, dummy.getIntegerValue());
    }

    @Test
    public void testBuildObjectWithSpecificNestedObject() {
        NestedDummy nestedDummy = Playdoh.build(NestedDummy.class);

        Dummy dummy = Playdoh.builder(Dummy.class)
                .with("nestedDummy", nestedDummy)
                .build();

        assertEquals(nestedDummy, dummy.getNestedDummy());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildObjectWithAbsentSpecificFieldName() {
        Playdoh.builder(Dummy.class)
                .with("absentValue", "test")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuildObjectWithoutSetterForFieldsShouldThrowError() {
        Playdoh.builder(ObjectWithInaccessibleFields.class).with("inaccessible", "aString").build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuildObjectWithoutAccessToSetterForFieldsShouldThrowError() {
        Playdoh.builder(ClassWithProtectedMethod.class).with("s", "aString").build();
    }

    public void testBuildObjectFromFixtureAndWithSpecificValue() {
        Playdoh.build(User.class, "aUser");
    }

    public class ClassWithProtectedMethod {
        private String s;

        protected String getS() {
            return s;
        }

        protected void setS(String s) {
            this.s = s;
        }
    }
}