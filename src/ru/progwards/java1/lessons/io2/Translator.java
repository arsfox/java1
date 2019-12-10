package ru.progwards.java1.lessons.io2;

public class Translator {

    private String[] inLang;
    private String[] outLang;

    public Translator(String[] inLang, String[] outLang) {
        this.inLang = inLang;
        this.outLang = outLang;
    }

    public String translate(String sentence) {
        String resultString = "";

        String[] arrForTranslate = sentence.split(" ");

        for (int c = 0; c < arrForTranslate.length; c ++){
            char[] wordChars = arrForTranslate[c].toCharArray();
            String wordCharsBuffer = "";
            String outWordBuffer = "";
            String outSymbolsBuffer = " ";
            for (char wordChar : wordChars) {
                if(Character.isAlphabetic(wordChar)){
                    wordCharsBuffer += Character.toLowerCase(wordChar);
                } else {
                    outSymbolsBuffer = String.valueOf(wordChar)+" ";
                }
            }

            for(int i = 0; i < inLang.length; i++) {
                if(wordCharsBuffer.equals(inLang[i])) {
                    outWordBuffer = outLang[i];
                }
            }

            if(Character.isUpperCase(arrForTranslate[c].charAt(0))) {
                outWordBuffer = outWordBuffer.substring(0, 1).toUpperCase() + outWordBuffer.substring(1);
            }


            resultString += outWordBuffer+outSymbolsBuffer;

        }
        resultString = resultString.substring(0, resultString.length() - 1);
        System.out.println(resultString);
        return resultString;
    }



}
