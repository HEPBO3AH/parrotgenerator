package com.dusanv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ConverterService {

    private LetterProvider letterProvider;

    public ConverterService(LetterProvider letterProvider) {
        this.letterProvider = letterProvider;
    }

    public void convertPhrase(String word, String foreground, String background) throws IOException {
        List<Character> characters = word.chars()
                .mapToObj(i -> (char)i)
                .map(Character::new)
                .collect(Collectors.toList());

        Word convertedWord = new Word();

        for(Character c : characters) {
            Letter letter = letterProvider.loadLetter(String.valueOf(c.charValue()));
            convertedWord.addLetter(letter);
        }

        String convertedWordAsString = convertedWord.compileWord(foreground, background);

        FileWriter fw = new FileWriter(word + ".txt");
        fw.write(convertedWordAsString);
        fw.close();
    }

}
