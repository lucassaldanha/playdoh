package com.lsoftware.playdoh.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionUtils {

    public static Iterable<Field> getFieldsUpHierarchy(Class<?> startClass) {
        return getFieldsUpHierarchy(startClass, null);
    }

    private static Iterable<Field> getFieldsUpHierarchy(Class<?> startClass, Class<?> exclusiveParent) {

        List<Field> currentClassFields = new ArrayList<Field>();
        currentClassFields.addAll(Arrays.asList(startClass.getDeclaredFields()));

        Class<?> parentClass = startClass.getSuperclass();

        if (parentClass != null &&
                (exclusiveParent == null || !(parentClass.equals(exclusiveParent)))) {
            List<Field> parentClassFields =
                    (List<Field>) getFieldsUpHierarchy(parentClass, exclusiveParent);
            currentClassFields.addAll(parentClassFields);
        }

        return currentClassFields;
    }

    public static Iterable<Method> getMethodsUpHierarchy(Class<?> startClass) {
        return getMethodsUpHierarchy(startClass, null);
    }

    private static Iterable<Method> getMethodsUpHierarchy(Class<?> startClass, Class<?> exclusiveParent) {

        List<Method> currentClassFields = new ArrayList<Method>();
        currentClassFields.addAll(Arrays.asList(startClass.getDeclaredMethods()));

        Class<?> parentClass = startClass.getSuperclass();

        if (parentClass != null &&
                (exclusiveParent == null || !(parentClass.equals(exclusiveParent)))) {
            List<Method> parentClassMethods =
                    (List<Method>) getMethodsUpHierarchy(parentClass, exclusiveParent);
            currentClassFields.addAll(parentClassMethods);
        }

        return currentClassFields;
    }

}
