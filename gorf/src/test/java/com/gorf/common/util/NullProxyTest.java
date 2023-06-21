package com.gorf.common.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for {@link NullProxy}.
 */
class NullProxyTest {

    @Test
    void onlyInterfacesAreAllowed() {
        assertNotNull(NullProxy.of(Runnable.class), "Expected non-null instance from an interface.");
        assertThrows(IllegalArgumentException.class, () -> NullProxy.of(ClassLoader.class), "Abstract classes are not allowed.");
        assertThrows(IllegalArgumentException.class, () -> NullProxy.of(String.class), "Concrete classes are not allowed.");
    }

    @Test
    void proxyMethodWithObjectReturnTypeReturnsNull() {
        TestInterface dummy = NullProxy.of(TestInterface.class);
        assertNotNull(dummy);
        assertNull(dummy.getObject());
    }

    @Test
    void proxyMethodWithPrimitiveReturnTypeReturnsDefaultValue() {
        TestInterface dummy = NullProxy.of(TestInterface.class);
        assertNotNull(dummy);

        assertEquals(Integer.valueOf("0"), (Integer) dummy.getInt());
        assertEquals(Long.valueOf("0"), (Long) dummy.getLong());
        assertEquals(Short.valueOf("0"), (Short) dummy.getShort());
        assertEquals(Float.valueOf("0"), (Float) dummy.getFloat());
        assertEquals(Double.valueOf("0"), (Double) dummy.getDouble());
        assertEquals(Byte.valueOf("0"), (Byte) dummy.getByte());
        assertEquals(Boolean.FALSE, dummy.getBoolean());
        assertEquals(Character.MIN_VALUE, dummy.getChar());
    }

    private interface TestInterface {

        Object getObject();

        int getInt();

        long getLong();

        short getShort();

        float getFloat();

        double getDouble();

        byte getByte();

        boolean getBoolean();

        char getChar();
    }
}
