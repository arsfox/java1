package ru.progwards.java1.lessons.maps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Arseniy on 05.02.2020.
 */
public class UsageFrequency {

    private ArrayList<String> words = new ArrayList<>();

    public void processFile(String fileName) {
//        try {
//            FileReader fileReader = new FileReader(fileName);
//            Scanner scanner = new Scanner(fileReader);
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] bufferWordsSymbols = line.split(" ");
//
//                for (String word : bufferWordsSymbols) {
//                    String clearWord = clearOut(word);
//                        System.out.println(clearWord);
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            int symbol = bufferedReader.read();
            String bufferWord = "";

            while (symbol != -1) {
                symbol = bufferedReader.read();
                Character charSymbol = (char) symbol;
                if(Character.isLetterOrDigit(charSymbol)) {
                    bufferWord += charSymbol;
                } else {
                    if(bufferWord.length() > 0) {
                        words.add(bufferWord);
                        bufferWord = "";
                    }
                }

            }
            System.out.println(words);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Character, Integer> getLetters() {
        return null;
    }

    public Map<String, Integer> getWords() {
        return null;
    }

    private static String clearOut (String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character .isLetterOrDigit(s.charAt(i)))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UsageFrequency a = new UsageFrequency();
        a.processFile("wiki.test.tokens");
    }
}
