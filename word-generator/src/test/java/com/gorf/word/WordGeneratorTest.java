package com.gorf.word;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordGeneratorTest {

    private static final String SYLLABLES_PATH = "D:\\David\\english_syllables.txt";

    @Test
    void testGenerate() {
        List<String> syllables = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(SYLLABLES_PATH))) {
            lines.collect(Collectors.toCollection(() -> syllables));
        } catch (IOException e) {
            e.printStackTrace();
        }

        WordGenerator generator = new WordGenerator();
        generator.generate(syllables);
    }
}
