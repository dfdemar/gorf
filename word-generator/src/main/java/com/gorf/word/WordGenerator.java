package com.gorf.word;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Generates random words based on English syllables and word fragments.
 */
public class WordGenerator {

    private static final int DEFAULT_WORD_COUNT = 5;

    private final Set<String> uniqueFragments = new HashSet<>();
    private final List<String> fragments = new ArrayList<>();

    private int maxSyllables = 3;

    /**
     * Adds a collection of word fragments to be used for generating words. Can be chained.
     */
    public WordGenerator addFragments(Collection<String> fragments) {
        this.uniqueFragments.addAll(fragments);
        return this;
    }

    public WordGenerator setMaxSyllables(int maxSyllables) {
        if (maxSyllables <= 1) {
            this.maxSyllables = 2;
        } else {
            this.maxSyllables = maxSyllables;
        }

        return this;
    }

    public List<String> generateWords() {
        return generateWords(DEFAULT_WORD_COUNT);
    }

    public List<String> generateWords(int wordCount) {
        if (wordCount <= 0) {
            return Collections.emptyList();
        }

        fragments.clear();
        fragments.addAll(uniqueFragments);

        return IntStream
            .range(0, wordCount)
            .mapToObj(i -> buildWord())
            .collect(Collectors.toList());
    }

    /**
     * Builds a word using random word fragments.
     */
    private String buildWord() {
        int syllableCount = ThreadLocalRandom.current().nextInt(2, maxSyllables + 1);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < syllableCount; i++) {
            builder.append(getRandomFragment());
        }
        return builder.toString();
    }

    /**
     * Returns a random word fragment.
     */
    private String getRandomFragment() {
        Random random = new Random();
        return fragments.get(random.nextInt(fragments.size()));
    }
}
