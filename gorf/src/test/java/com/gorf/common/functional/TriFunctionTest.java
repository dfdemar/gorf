package com.gorf.common.functional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link TriFunction}.
 */
class TriFunctionTest {

    /**
     * Verifies that the TriConsumer passed to {@code TriFunction.andThen} runs after {@code TriConsumer.apply}.
     */
    @Test
    void andThenExecutesAfterAccept() {
        TriFunction<String, String, String, String> first = (x, y, z) -> x + y + z;
        Function<String, String> second = (x) -> x + "!";

        String result = first.andThen(second).apply("Hello", " ", "World");
        assertEquals("Hello World!", result);
    }

    /**
     * Verifies that an exception is thrown if the object passed to {@code TriFunction.andThen} is null.
     */
    @Test
    void throwsExceptionIfValueIsNull() {
        TriFunction<String, String, String, String> doIt = (a, b, c) -> a + b + c;
        Assertions.assertThrows(NullPointerException.class, () -> doIt.andThen(null).apply("a", "b", "c"));
    }
}
