package com.gorf.functional;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {

    /**
     * Applies this function to the given arguments and returns the result.
     */
    R apply(T var1, U var2, V var3);
}
