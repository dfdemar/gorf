package com.gorf.word;

import java.util.List;
import java.util.Random;

/**
 * Generates random words based on English syllables.
 */
public class WordGenerator {

    public void generate(List<String> syllables) {
        for (int i = 0; i < 10; i++) {
            String word = buildWord(syllables);
            System.out.println(word);
        }
    }

    /**
     * Builds a word using random syllables.
     */
    private String buildWord(List<String> syllables) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            builder.append(getSyllable(syllables));
        }
        return builder.toString();
    }

    /**
     * Returns a random syllable.
     */
    private String getSyllable(List<String> syllables) {
        Random random = new Random();
        return syllables.get(random.nextInt(syllables.size()));
    }
}
