package com.gorf;

import com.gorf.test.BadPractices;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * Tests that scan the source code looking for bad practices.
 */
class BadPracticesTest {

    /**
     * Runs the BadPractices test for this module.
     */
    @Test
    void runTest() throws Exception {
        final File currentPath = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        final File moduleRootPath = currentPath.getParentFile().getParentFile();
        BadPractices.check(moduleRootPath);
    }
}
