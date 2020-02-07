package ru.progwards.java1.lessons.maps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
        Map<String, Integer> lettersCounter = new HashMap<String, Integer>();
        HashSet<Character> letters = new HashSet<>();
//        for(letters)
        return null;
    }

    public Map<String, Integer> getWords() {
        Map<String, Integer> wordsCounter = new HashMap<String, Integer>();

        for (String word : words) {
            if(wordsCounter.containsKey(word)){
                int count = wordsCounter.get(word);
                wordsCounter.put(word, count + 1);
            } else {
                wordsCounter.put(word, 1);
            }
//            int counter = 1;
//            for (String wordSearch : words) {
//                if(wordSearch.equals(word)){
//                    counter ++;
//                }
//            }
//            wordsCounter.putIfAbsent(word, counter);
        }
        return wordsCounter;
    }

    public static void main(String[] args) {
        UsageFrequency a = new UsageFrequency();
        a.processFile("wiki.test.tokens");
        System.out.println(a.getWords());
    }
}
