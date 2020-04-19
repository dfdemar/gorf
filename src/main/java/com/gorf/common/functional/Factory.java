package com.gorf.common.functional;

/**
 * Interface for a basic factory.
 *
 * @param <T> some type of data used to identify the type of object to be returned
 * @param <R> type of object to be returned
 */
@FunctionalInterface
public interface Factory<T, R> {

    <E extends Exception> R create(T key) throws E;
}
