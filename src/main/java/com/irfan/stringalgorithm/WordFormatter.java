package com.irfan.stringalgorithm;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFormatter {

    public static boolean isPalindrom(String words) {
        if (words.length() == 1) return true;

        Integer halfLength = words.length() / 2 ;
        String firstHalf = words.substring(0, halfLength);
        String secondHalf = words.substring(halfLength + 1, words.length());

        return firstHalf.equalsIgnoreCase(reverseSequence(secondHalf));
    }

    public static String reverseSequence(String words) {
        String[] wordArray = words.split(" ");
        String result = Arrays.stream(wordArray).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
        return result;
    }

    public static String reverseCase(String words) {
        Stream<Character> wordStream = words.chars().mapToObj(i -> (char) i);
        String result = wordStream
                .map(c -> flipCase(c))
                .map(c -> c.toString())
                .collect(Collectors.joining());

        return result;
    }

    private static Character flipCase(Character character) {
        if (Character.isUpperCase(character)) {
            return Character.toLowerCase(character);
        }
        if (Character.isLowerCase(character)){
            return Character.toUpperCase(character);
        }
        return character;
    }
}
