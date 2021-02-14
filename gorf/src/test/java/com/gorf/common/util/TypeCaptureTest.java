package com.gorf.common.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TypeCaptureTest {

    @Test
    void testCapture() {
        Class<List<String>> clazz = TypeCapture.capture(List.class);
        assertTrue(clazz.isAssignableFrom(new ArrayList<String>().getClass()));
    }
}
