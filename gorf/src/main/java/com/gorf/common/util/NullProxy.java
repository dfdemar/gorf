package com.gorf.common.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * Dynamically implements the "null object pattern" for an interface.
 */
public class NullProxy implements InvocationHandler {

    /**
     * Creates a "null object" instance of an interface that proxies every method of the returned instance to be a no-op.
     */
    public static <T> T of(Class<T> interfaceClass) {
        if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException(interfaceClass.getName() + " must be an interface.");
        }

        Object instance = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] {interfaceClass}, new NullProxy());
        return interfaceClass.cast(instance);
    }

    /**
     * Makes every method call on the proxy object do absolutely nothing. Methods that return a value will return null instead. If
     * the return type is a Java primitive, the default value of that primitive will be returned.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        return getDefaultOrNull(method.getReturnType());
    }

    private Object getDefaultOrNull(Class<?> param) {
        if (Objects.equals(param, int.class)) {
            return 0;
        } else if (Objects.equals(param, long.class)) {
            return Long.valueOf("0");
        } else if (Objects.equals(param, short.class)) {
            return Short.valueOf("0");
        } else if (Objects.equals(param, float.class)) {
            return Float.valueOf("0");
        } else if (Objects.equals(param, double.class)) {
            return Double.valueOf("0");
        } else if (Objects.equals(param, byte.class)) {
            return Byte.valueOf("0");
        } else if (Objects.equals(param, boolean.class)) {
            return Boolean.FALSE;
        } else if (Objects.equals(param, char.class)) {
            return Character.MIN_VALUE;
        }

        return null;
    }
}
