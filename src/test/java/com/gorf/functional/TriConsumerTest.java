package com.gorf.functional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Tests for {@link TriConsumer}.
 */
class TriConsumerTest {

    /**
     * Verifies that the TriConsumer passed to {@code TriConsumer.andThen} runs after {@code TriConsumer.accept}.
     */
    @Test
    void andThenExecutesAfterAccept() {
        List<Integer> results = new ArrayList<>();
        TriConsumer<String, String, String> first = (x, y, z) -> results.add(1);
        TriConsumer<String, String, String> second = (x, y, z) -> results.add(2);

        first.andThen(second).accept("", "", "");
        assertEquals(2, results.size());
        assertEquals(1, (int) results.get(0));
        assertEquals(2, (int) results.get(1));
    }

    /**
     * Verifies that an exception is thrown if the object passed to {@code TriConsumer.andThen} is null.
     */
    @Test
    void throwsExceptionIfValueIsNull() {
        TriConsumer<String, String, String> consumer = (a, b, c) -> fail("TriConsumer should not execute.");
        Assertions.assertThrows(NullPointerException.class, () -> consumer.andThen(null).accept("a", "b", "c"));
    }
}
