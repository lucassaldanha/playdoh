package com.lsoftware.playdoh;

import com.lsoftware.playdoh.generator.TypeValueGenerator;
import com.lsoftware.playdoh.generator.ValueGeneratorFactory;
import com.lsoftware.playdoh.generator.ValueGeneratorFactoryImpl;
import com.lsoftware.playdoh.resolver.InterfaceResolver;
import com.lsoftware.playdoh.resolver.InterfaceResolverImpl;
import com.lsoftware.playdoh.util.Primitives;
import com.lsoftware.playdoh.util.ReflectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unchecked")
public final class ObjectBuilderImpl implements ObjectBuilder {

    private static final ValueGeneratorFactory valueGeneratorFactory = new ValueGeneratorFactoryImpl();

    private static final InterfaceResolver interfaceResolver = new InterfaceResolverImpl();

    private Class<?> type;
    private Object object;

    <T> ObjectBuilderImpl(Class<T> type){
        this.type = type;
    }

    @Override
    public ObjectBuilder with(String name, Object value) {
        object = build();

        final Field field = searchForFieldByName(name);
        final Method setter = findSetter(object.getClass(), field);

        if(setter == null) {
            throw new IllegalArgumentException("Unable to find setter for field " + field.getName()
                    + " on object of type " + type.getClass().getName());
        }

        setValueUsingSetter(value, setter);

        return this;
    }

    private Field searchForFieldByName(String name) {
        for (Field field : ReflectionUtils.getFieldsUpHierarchy(object.getClass())) {
            if (field.getName().equalsIgnoreCase(name)) {
                return field;
            }
        }

        throw new IllegalArgumentException("Can't find field with name " + name
                + " in class " + object.getClass().getSimpleName());
    }

    private void setValueUsingSetter(Object value, Method setter) {
        try {
            setter.setAccessible(true);
            setter.invoke(object, value);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unable to set call " + setter.getName() + ". Is this method public or protected?");
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Error calling " + setter.getName(), e);
        }
    }

    @Override
    public <T> T build() {
        if(object == null) {
            object = doBuild(type);
        }

        return (T) object;
    }

    protected  <T> T doBuild(Class<T> type) {
        if(valueGeneratorFactory.existsForType(type)) {
            final TypeValueGenerator typeGenerator = valueGeneratorFactory.getFromType(type);
            if(type.isArray()) {
                return (T) typeGenerator.generateArray();
            } else {
                return (T) typeGenerator.generate();
            }
        } else if(type.isEnum()) {
            return buildEnum(type);
        } else {
            if(Modifier.isInterface(type.getModifiers())) {
                type = interfaceResolver.concreteType(type);
                return interfaceResolver.populate(type);
            } else {
                Object o = createInstance(type);
                populateFields(o);
                return (T) o;
            }
        }
    }

    private <T> T buildEnum(Class<T> type) {
        final T[] enumConstants = type.getEnumConstants();
        return enumConstants[new Random().nextInt(enumConstants.length)];
    }

    private Object createInstance(Class type) {
        try {
            if(Modifier.isInterface(type.getModifiers()) || Modifier.isAbstract(type.getModifiers())) {
                throw new IllegalStateException("Cannot find a Generator for the " + type.getSimpleName() + " interface");
            }


            Constructor constructor = type.getDeclaredConstructors()[0];
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            constructor.setAccessible(true);
            if (parameterTypes.length == 0) {
                return constructor.newInstance();
            } else {
                List<Object> params = new ArrayList<Object>();
                for (Class<?> pType : constructor.getParameterTypes()) {
                    params.add(doBuild(pType));
                }
                return constructor.newInstance(params.toArray());
            }

        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate object of type " + type.getName(), e);
        }
    }

    private void populateFields(Object object) {
        final Class<?> clazz = object.getClass();
        for (Field field : ReflectionUtils.getFieldsUpHierarchy(object.getClass())) {
            final Method setter = findSetter(clazz, field);
            if(setter != null) {
                setter.setAccessible(true);
                useSetterToPopulateField(object, field, setter);
            }
        }
    }

    private void useSetterToPopulateField(Object object, Field field, Method setter) {
        final Object value = doBuild(field.getType());
        populateFieldWithValueUsingSetter(object, field, value, setter);
    }

    private void populateFieldWithValueUsingSetter(Object object, Field field, Object value, Method setter) {
        try {
            //Handle primitive arrays
            if(Primitives.isPrimitiveArray(field.getType())) {
                setPrimitiveArrayValue(object, field, setter, value);
            } else {
                setter.setAccessible(true);
                setter.invoke(object, value);
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to set value to field " + field.getName()
                    + " on object of type " + object.getClass().getName(), e);
        }
    }

    private void setPrimitiveArrayValue(Object object, Field field, Method setter, Object value) throws IllegalAccessException, InvocationTargetException {
        if(field.getType().equals(byte[].class)) {
            setter.invoke(object, ArrayUtils.toPrimitive((Byte[]) value));
        } else if(field.getType().equals(short[].class)) {
            setter.invoke(object, ArrayUtils.toPrimitive((Short[]) value));
        } else if(field.getType().equals(int[].class)) {
            setter.invoke(object, ArrayUtils.toPrimitive((Integer[]) value));
        } else if(field.getType().equals(long[].class)) {
            setter.invoke(object, ArrayUtils.toPrimitive((Long[]) value));
        } else if(field.getType().equals(float[].class)) {
            setter.invoke(object, ArrayUtils.toPrimitive((Float[]) value));
        } else if(field.getType().equals(double[].class)) {
            setter.invoke(object, ArrayUtils.toPrimitive((Double[]) value));
        } else if(field.getType().equals(boolean[].class)) {
            setter.invoke(object, ArrayUtils.toPrimitive((Boolean[]) value));
        } else if(field.getType().equals(char[].class)) {
            setter.invoke(object, ArrayUtils.toPrimitive((Character[]) value));
        }
    }

    private Method findSetter(Class clazz, Field field) {
        final String fieldName = field.getName();
        for (Method method : ReflectionUtils.getMethodsUpHierarchy(clazz)) {
            if (method.getName().equalsIgnoreCase("set" + fieldName)) {
                return method;
            }
        }

        return null;
    }


}
