package ru.progwards.java1.lessons.io2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Censor {

    public static void censorFile(String inoutFileName, String[] obscene)  {

        try(FileReader reader = new FileReader(inoutFileName)) {
            Scanner scanner = new Scanner(reader);
            String resultLines = "";
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String wordReplaceBuffer = str;
                for (String wordObscene : obscene) {
                    wordReplaceBuffer = wordReplaceBuffer.replace(wordObscene, getStar(wordObscene));
                }
                resultLines += wordReplaceBuffer;
            }
            try(FileWriter writer = new FileWriter(inoutFileName, false)) {
                writer.write("");
                writer.write(resultLines);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getStar(String word){
        int starInt = word.length();
        String star = "";
        while (starInt > 0){
            star += "*";
            starInt--;
        }
        return star;
    }

}
