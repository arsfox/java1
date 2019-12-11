package ru.progwards.java1.lessons.io2;

/**
 * Created by Arseniy on 09.12.2019.
 */
public class PhoneNumber {

    public static String format(String phone) {
        String number = "";
        char[] numArray = phone.toCharArray();
        for (int i = 0; i < numArray.length; i++) {
            if (Character.isDigit(numArray[i])) {
                number += numArray[i];

            }
        }

        if((number.length() < 10)||(number.length() > 11)){
            try {
                throw new Exception("Wrong number length");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if((number.substring(0, 1).equals("8"))&&(number.length() == 11)) {
            number = number.substring(1);
        } else
        if((number.length() == 12)&&(number.substring(0, 1).equals("7"))) {
            number = number.substring(1);
        } else
        if((number.substring(0, 2).equals("+7"))&&(number.length() == 12)) {
            number = number.substring(2);
        }

        number = "+7"+number;

        char[] numberArray = number.toCharArray();
        number = "";
        for (int count = 0; count < numberArray.length; count++) {
            if(count == 2){
                number += "(";
            }
            if(count == 5){
                number += ")";
            }
            if(count == 8){
                number += "-";
            }
            number += numberArray[count];
        }
        return number;
    }

}
