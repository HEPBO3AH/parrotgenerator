package com.dusanv;

import java.util.ArrayList;
import java.util.List;

public class Word {

    List<Letter> letters = new ArrayList<>();

    public Word() {
    }

    public Word(List<Letter> letters) {
        this.letters = letters;
    }

    public Word addLetter(Letter letter) {
        letters.add(letter);
        return this;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public String slackify(int lineNumber, String foreground, String background) {
        StringBuilder result = new StringBuilder();
        result.append(background);
        for (Letter letter : letters) {
            try {
                String line = letter.getLine(lineNumber);
                line = line.replace("y", background);
                line = line.replace("x", foreground);
                result.append(line);
                result.append(background);
            } catch (Exception ex) {
                System.out.println("Cannot fetch line for letter: " + letter.toString());
            }
        }
        return result.toString();
    }
}
