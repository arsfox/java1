package ru.progwards.java1.lessons.sets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LettersInFile {

    public static String process(String fileName) throws IOException {
        Set<Character> character = new TreeSet<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        int symbol = bufferedReader.read();
        while (symbol != -1) {
            char c = (char) symbol;
            if(Character.isAlphabetic(c)) {
                character.add(c);
            }
            symbol = bufferedReader.read();
        }
        bufferedReader.close();

        return toString(character);
    }

    private static String toString(Set<Character> character) {
        String result = "";
        for (Character c : character) {
            result += c;
        }

        return result;
    }

}
