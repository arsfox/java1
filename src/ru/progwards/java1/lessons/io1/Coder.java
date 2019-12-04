package ru.progwards.java1.lessons.io1;

import java.io.*;

/**
 * Created by Arseniy on 04.12.2019.
 */
public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inFileName));
            int symbol = bufferedReader.read();
            while (symbol != -1) {
                char c = (char) symbol;
                for(char cod : code){
                    if
                }
                symbol = bufferedReader.read(); // Читаем символ
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
