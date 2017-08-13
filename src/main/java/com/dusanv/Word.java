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

    public String compileWord(String foreground, String background) {
        Integer maxHeight = letters.stream().map(Letter::getHeight).max(Integer::compareTo).orElseThrow(() -> new RuntimeException("Failed to get max letter height"));

        StringBuilder finalOutput = new StringBuilder();
        for (int currentLine = 0; currentLine < maxHeight; currentLine++) {
            finalOutput.append(background);
            for (Letter letter : letters) {
                try {
                    String line = letter.getLine(currentLine);
                    line = line.replace("y", background);
                    line = line.replace("x", foreground);
                    finalOutput.append(line);
                    finalOutput.append(background);
                } catch (Exception ex) {
                    System.out.println("Cannot fetch this line for letter: " + letter.toString());
                }
            }
            finalOutput.append("\r\n");
        }

        return finalOutput.toString();
    }
}
