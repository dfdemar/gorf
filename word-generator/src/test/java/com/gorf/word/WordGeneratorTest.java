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

    private static final String SYLLABLES_PATH = "src/main/resources/common-english-syllables.txt";

    @Test
    void generateWords() {
        List<String> syllables = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(SYLLABLES_PATH))) {
            lines.collect(Collectors.toCollection(() -> syllables));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> words = new WordGenerator()
            .addFragments(syllables)
            .setMaxSyllables(4)
            .generateWords();

        words.forEach(System.out::println);
    }
}
