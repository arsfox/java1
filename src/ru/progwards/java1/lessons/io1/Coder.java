package ru.progwards.java1.lessons.io1;

import java.io.*;

/**
 * Created by Arseniy on 04.12.2019.
 */
public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {

        try {

            String outFileString = "";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(inFileName));
            int symbol = bufferedReader.read();
            while (symbol != -1) {
                try {
                outFileString += code[symbol];
                } catch (ArrayIndexOutOfBoundsException e) {
                    setText(logName, e.getMessage());
                }
                symbol = bufferedReader.read();
            }
            bufferedReader.close();
            setText(outFileName, outFileString);
        } catch (FileNotFoundException e) {
                setText(logName, e.getMessage());
        } catch (IOException e) {
                setText(logName, e.getMessage());
        }
    }

    private static void setText(String fileName, String text)  {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, false);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            setText(fileName, e.getMessage()); // =)
        }

    }

}
