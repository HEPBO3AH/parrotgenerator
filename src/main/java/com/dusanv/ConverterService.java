package com.dusanv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConverterService {

    private LetterProvider letterProvider;

    @Autowired
    public ConverterService(LetterProvider letterProvider) {
        this.letterProvider = letterProvider;
    }

    public String convertPhrase(String phraseString, String foreground, String background) throws IOException {
        String[] wordListAsString = phraseString.split(" ");
        List<Word> wordList = new LinkedList<>();
        for (String word : wordListAsString) {
            List<Character> characters = word.chars()
                    .mapToObj(i -> (char) i)
                    .map(Character::new)
                    .collect(Collectors.toList());

            Word convertedWord = new Word();

            for (Character c : characters) {
                Letter letter = letterProvider.loadLetter(String.valueOf(c.charValue()));
                convertedWord.addLetter(letter);
            }

            wordList.add(convertedWord);
        }
        Phrase phrase = new Phrase(wordList);

        return phrase.slackify(foreground, background);
    }

}
