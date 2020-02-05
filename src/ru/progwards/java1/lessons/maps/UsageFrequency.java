package ru.progwards.java1.lessons.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Arseniy on 05.02.2020.
 */
public class UsageFrequency {

    private ArrayList<String> words = new ArrayList<>();

    public void processFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<Character, Integer> getLetters() {
        return null;
    }

    public Map<String, Integer> getWords() {
        return null;
    }

    public static void main(String[] args) {
        UsageFrequency a = new UsageFrequency();

    }
}
