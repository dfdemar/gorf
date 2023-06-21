package com.gorf.word;

import org.junit.jupiter.api.BeforeAll;
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
    private static final List<String > SYLLABLES = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        try (Stream<String> lines = Files.lines(Paths.get(SYLLABLES_PATH))) {
            lines.collect(Collectors.toCollection(() -> SYLLABLES));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void generateWords() {
        List<String> words = new WordGenerator()
            .addFragments(SYLLABLES)
            .setMaxSyllables(4)
            .generateWords();

        words.forEach(System.out::println);
    }

    @Test
    void generateSentences() {
        List<String> sentences = new WordGenerator()
            .addFragments(SYLLABLES)
            .setMaxSyllables(4)
            .generateSentences();

        sentences.forEach(System.out::println);
    }
}
