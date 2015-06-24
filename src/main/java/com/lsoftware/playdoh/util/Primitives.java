package com.lsoftware.playdoh.util;

public enum Primitives {

    BYTE    ("byte", Byte.class, "[B"),
    SHORT   ("short", Short.class, "[S"),
    INT     ("int", Integer.class, "[I"),
    LONG    ("long", Long.class, "[J"),
    FLOAT   ("float", Float.class, "[F"),
    DOUBLE  ("double", Double.class, "D"),
    BOOLEAN ("boolean", Boolean.class, "[Z"),
    CHAR    ("char", Character.class, "[C");

    private final String label;

    private final Class wrapperType;

    private final String primitiveArrayName;

    Primitives(String label, Class wrapperType, String primitiveArrayName) {
        this.label = label;
        this.wrapperType = wrapperType;
        this.primitiveArrayName = primitiveArrayName;
    }

    private String getLabel() {
        return this.label;
    }

    public static Class getWrapper(Class type) {
        if(isPrimitive(type)) {
            return Primitives.findByLabel(type.getSimpleName()).wrapperType;
        } else if(isPrimitiveArray(type)) {
            return Primitives.findByLabel(ClassUtils.getClassNameFromArray(type))
                    .wrapperType;
        } else {
            throw new IllegalArgumentException("Not a primitive type: " + type.getSimpleName());
        }
    }

    public static boolean isPrimitive(Class type) {
        return isPrimitive(type.getSimpleName());
    }

    private static boolean isPrimitive(String typeName) {
        for (Primitives primitives : Primitives.values()) {
            if(typeName.equals(primitives.getLabel())) {
                return true;
            }
        }

        return false;
    }

    public static boolean isPrimitiveArray(Class type) {
        return isPrimitive(type.getSimpleName().substring(0, type.getSimpleName().length() - 2));
    }

    private static Primitives findByLabel(String label) {
        for (Primitives primitive : Primitives.values()) {
            if(primitive.getLabel().equals(label)) {
                return primitive;
            }
        }

        throw new IllegalArgumentException("Not a primitive label: " + label);
    }

}
