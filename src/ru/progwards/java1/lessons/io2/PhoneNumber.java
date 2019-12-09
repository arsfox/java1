package ru.progwards.java1.lessons.io2;

/**
 * Created by Arseniy on 09.12.2019.
 */
public class PhoneNumber {

    public static String format(String phone) {
        String number = "";
        int c = 0;
        char[] numArray = phone.toCharArray();

        for (int i = 0; i < numArray.length; i++) {
            if (Character.isDigit(numArray[i])) {
                number += numArray[i];
            }
        }

        if((number.length() >= 11) || (number.length() < 10)){
            try {
                throw new Exception("Wrong number length");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(number);



        return "";
    }

}
