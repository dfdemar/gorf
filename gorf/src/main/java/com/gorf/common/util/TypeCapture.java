package com.gorf.common.util;

public class TypeCapture {

    /**
     * Captures a class literal, which can also be a generic type.
     */
    public static <T> T capture(Class<?> clazz) {
        return (T) clazz;
    }
}
