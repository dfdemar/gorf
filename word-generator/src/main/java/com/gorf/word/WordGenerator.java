package com.gorf.word;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Generates random words based on English syllables and word fragments.
 */
public class WordGenerator {

    private final Set<String> uniqueFragments = new HashSet<>();
    private List<String> fragments = new ArrayList<>();

    /**
     * Adds a collection of word fragments to be used for generating words. Can be chained.
     */
    public WordGenerator addFragments(Collection<String> fragments) {
        this.uniqueFragments.addAll(fragments);
        return this;
    }

    public void generate() {
        fragments = new ArrayList<>(uniqueFragments);

        for (int i = 0; i < 10; i++) {
            String word = buildWord();
            System.out.println(word);
        }
    }

    /**
     * Builds a word using random word fragments.
     */
    private String buildWord() {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < 3; j++) {
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
