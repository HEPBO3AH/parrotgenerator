package com.dusanv;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class LetterProvider {
    private static ClassLoader classLoader = LetterProvider.class.getClassLoader();

    public Letter loadLetter(String letter) {
        InputStream resourceAsStream = classLoader.getResourceAsStream(letter.toUpperCase());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));

        List<String> collect = bufferedReader.lines().collect(Collectors.toList());
        return new Letter(collect);
    }
}
