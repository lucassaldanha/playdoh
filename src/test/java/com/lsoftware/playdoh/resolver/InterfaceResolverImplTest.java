package com.lsoftware.playdoh.resolver;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class InterfaceResolverImplTest {

    private InterfaceResolverImpl interfaceResolver;

    @Before
    public void beforeTests() {
        interfaceResolver = new InterfaceResolverImpl();
    }

    @Test
    public void testDefaultMappersContainsJavaCollectionsMapper() {
        assertTrue(new InterfaceResolverImpl().getMappers().get(0) instanceof JavaCollectionsMapper);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetConcreteTypeForTypeWithoutResolverThrowsError() {
        interfaceResolver.concreteType(UnmappedInterface.class);
    }

    @Test
    public void testGetConcreteTypeForMappedTypeResolvesToConcreteClass() {
        Class concrete = interfaceResolver.concreteType(Collection.class);
        assertNotNull(concrete);
        assertEquals(HashSet.class.getSimpleName(), concrete.getSimpleName());
    }

    @Test
    public void testAddMapperResolvesUnresolveableInterface() {
        try {
            interfaceResolver.concreteType(UnmappedInterface.class);
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }

        createUnmappedInterfaceMapper();

        Class concreteType = interfaceResolver.concreteType(UnmappedInterface.class);
        assertEquals(ConcreteUnmappedInterface.class, concreteType);
    }

    private void createUnmappedInterfaceMapper() {
        interfaceResolver.addMapper(new InterfaceMapper() {
            @Override
            public boolean apply(Class type) {
                return true;
            }

            @Override
            public Class getConcreteType(Class type) {
                if(type.equals(UnmappedInterface.class)) {
                    return ConcreteUnmappedInterface.class;
                } else {
                    throw new RuntimeException();
                }
            }
        });
    }

    public interface UnmappedInterface {
    }

    public class ConcreteUnmappedInterface implements UnmappedInterface{
    }

}