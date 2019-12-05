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
                char codeChar = code[symbol];
                outFileString += codeChar;
                symbol = bufferedReader.read();
            }

            setText(outFileName);
        } catch (FileNotFoundException e) {
            try {
                setText(e.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } catch (IOException e) {
            try {
                setText(e.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    private static void setText(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName, false);
        writer.write(fileName);
        writer.close();
    }

}
