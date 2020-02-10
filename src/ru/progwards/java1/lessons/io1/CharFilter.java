package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {

    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader fileReader = new FileReader(inFileName);
        FileWriter writer = new FileWriter(outFileName, false);
        try {
        Scanner scanner = new Scanner(fileReader);
        String outFileString = "";
        while ((scanner.hasNextLine())) {
            String lineText = scanner.nextLine();
            for (int i = 0; i < lineText.length(); i++) {
                String out = String.valueOf(lineText.charAt(i));
                for (int c = 0; c < filter.length(); c++) {
                    if (lineText.charAt(i) == filter.charAt(c)) {
                        out = "";
                    }
                }
                outFileString += out;
            }
        }
        writer.write(outFileString);

        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            fileReader.close();
            writer.close();
        }
    }
}
