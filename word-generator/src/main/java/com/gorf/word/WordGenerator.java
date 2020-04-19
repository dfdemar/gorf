package com.gorf.word;

import java.util.List;
import java.util.Random;

/**
 * Generates random words based on English syllables.
 */
public class WordGenerator {

    public void generate(List<String> syllables) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append(getSyllable(syllables));
        }
        System.out.println(builder.toString());
    }

    /**
     * Returns a random syllable.
     */
    private String getSyllable(List<String> syllables) {
        Random random = new Random();
        return syllables.get(random.nextInt(syllables.size()));
    }
}
