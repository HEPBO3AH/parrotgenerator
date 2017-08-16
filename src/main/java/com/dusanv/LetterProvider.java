package com.dusanv;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LetterProvider {
    private static ClassLoader classLoader = LetterProvider.class.getClassLoader();
    private Map<String, Letter> loadedLetters = new HashMap();

    public Letter loadLetter(String letterString) {
        Optional<Letter> existingLetter = Optional.ofNullable(loadedLetters.get(letterString));

        if (existingLetter.isPresent()) {
            return existingLetter.get();
        }

        InputStream resourceAsStream = classLoader.getResourceAsStream(letterString.toUpperCase());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));

        List<String> collect = bufferedReader.lines().collect(Collectors.toList());
        Letter letter = new Letter(collect);
        loadedLetters.put(letterString, letter);
        return letter;
    }
}
