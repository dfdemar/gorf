package com.gorf.functional;

@FunctionalInterface
public interface TriConsumer <T, U, V> {

    /**
     * Performs this operation on the given arguments and returns no results.
     */
    void accept(T var1, U var2, V var3);
}
