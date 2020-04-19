package com.gorf.word;

import java.util.List;
import java.util.Random;

/**
 * Generates random words based on English syllables.
 */
public class WordGenerator {

    public void generate(List<String> syllables) {
        System.out.println(getSyllable(syllables));
    }

    /**
     * Returns a random syllable.
     */
    private String getSyllable(List<String> syllables) {
        Random random = new Random();
        return syllables.get(random.nextInt(syllables.size()));
    }
}
