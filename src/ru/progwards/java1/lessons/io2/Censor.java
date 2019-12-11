package ru.progwards.java1.lessons.io2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Censor {

    public static void censorFile(String inoutFileName, String[] obscene) throws CensorException {

        try {
            FileReader reader = new FileReader(inoutFileName);
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
            reader.close();
            FileWriter writer = new FileWriter(inoutFileName, false);
            writer.write("");
            writer.write(resultLines);
            writer.close();
        } catch (IOException e) {
            throw new CensorException(inoutFileName);
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

    public static class CensorException extends Exception {
        private String exceptionMess = this.getMessage();
        private String filename;

        public CensorException(String filename){
            super();
            this.filename = filename;
        }

        @Override
        public String getMessage() {
            return filename+":"+super.getMessage();
        }

        @Override
        public String toString() {
            return filename+":"+exceptionMess;
        }
    }

}
