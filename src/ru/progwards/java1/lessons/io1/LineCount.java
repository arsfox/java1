package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {

    public static int calcEmpty(String fileName) {
        try {
            FileReader file = new FileReader(fileName);
            Scanner scanner = new Scanner(file);
            int count = 0;
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if(str.equals("\n")){
                    count++;
                }
            }
            return count;
        } catch (IOException e) {
            return -1;
        }
    }
}
