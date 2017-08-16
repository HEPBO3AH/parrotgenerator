package com.dusanv;

import java.util.List;

public class Phrase {

    private List<Word> words;
    private int tallestLetterHeight;

    public Phrase(List<Word> words) {
        this.words = words;
        tallestLetterHeight = words
                .stream()
                .flatMap(w -> w.getLetters().stream())
                .map(Letter::getHeight)
                .max(Integer::compareTo).orElseThrow(() -> new RuntimeException("There are no letters in the phrase"));

    }

    public String slackify(String foreground, String background) {
        StringBuilder result = new StringBuilder();
        for (int rowIndex = 0; rowIndex < tallestLetterHeight; rowIndex++) {
            for (int wordIndex = 0; wordIndex < words.size(); wordIndex++) {
                result.append(words.get(wordIndex).slackify(rowIndex, foreground, background));
                if (wordIndex < words.size() - 1) {
                    result.append(background);
                }
            }
            result.append("\r\n");
        }

        return result.toString();
    }
}
