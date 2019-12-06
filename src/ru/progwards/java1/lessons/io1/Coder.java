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
                symbol = bufferedReader.read();
                try {
                outFileString += code[symbol];
                } catch (ArrayIndexOutOfBoundsException e) {
                    try {
                        setText(logName, e.getMessage());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
            bufferedReader.close();
            setText(outFileName, outFileString);
        } catch (FileNotFoundException e) {
            try {
                setText(logName, e.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } catch (IOException e) {
            try {
                setText(logName, e.getMessage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    private static void setText(String fileName, String text) throws IOException {
        FileWriter writer = new FileWriter(fileName, false);
        writer.write(text);
        writer.close();
    }

}
