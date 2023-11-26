package com.example.programowaniezaawansowane.zadanie5;

import java.util.stream.Collectors;

public class CaesarCiper {
    private static final int SHIFT = 3;

    public static String encrypt(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .map(c -> encryptChar(c, SHIFT))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static char encryptChar(char c, int shift) {
        if (Character.isUpperCase(c)) {
            return (char) ((c - 'A' + shift) % 26 + 'A');
        } else if (Character.isLowerCase(c)) {
            return (char) ((c - 'a' + shift) % 26 + 'a');
        } else {
            return c;
        }
    }

}
