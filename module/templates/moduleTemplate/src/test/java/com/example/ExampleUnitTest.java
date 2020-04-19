package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Example of how to write a unit test using JUnit 5.
 */
class ExampleUnitTest {

    /**
     * Explain the significance of the test and what is being tested.
     */
    @Test
    void exampleTest() {
        boolean result = 99 > 100;
        Assertions.assertTrue(result, "Expected 99 to be less than 100.");
    }
}
