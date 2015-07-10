package com.lsoftware.playdoh.generator;

import com.lsoftware.playdoh.objects.models.Dummy;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValueGeneratorFactoryImplTest {

    private ValueGeneratorFactoryImpl valueGeneratorFactory = new ValueGeneratorFactoryImpl();

    @Test
    public void testRegister() throws Exception {
        assertFalse(valueGeneratorFactory.existsForType(Dummy.class));

        valueGeneratorFactory.register(Dummy.class, new TypeValueGenerator() {
            @Override
            public Object generate() {
                return new Dummy();
            }

            @Override
            public Dummy[] generateArray() {
                return new Dummy[0];
            }
        });

        assertTrue(valueGeneratorFactory.existsForType(Dummy.class));
    }
}