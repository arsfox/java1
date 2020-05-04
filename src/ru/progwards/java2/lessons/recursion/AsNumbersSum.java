package ru.progwards.java2.lessons.recursion;

public class AsNumbersSum {
// Я НЕ СМОГ РЕШИТЬ ЭТУ ЗАДАЧУ
    public static void main(String[] args) {
        System.out.println("6 = 5+1 = 4+2 = 4+1+1 = 3+3 = 3+2+1 = 3+1+1+1 = 2+2+2 = 2+2+1+1 = 2+1+1+1+1 = 1+1+1+1+1+1.");
        System.out.println(asNumbersSum(6));
    }

    static int asNumber;
    // Я НЕ СМОГ РЕШИТЬ ЭТУ ЗАДАЧУ
    static String asNumbersSum(int number){
        asNumber = number;
        System.out.print(6);
        return asNumbers(number);
    }
    // Я НЕ СМОГ РЕШИТЬ ЭТУ ЗАДАЧУ
    static String asNumbers(int number) {
        if(number <= 1){
            return "";
        }
        int a = number - 1;
        int b = asNumber - a;
        System.out.print(" = "+a+"+"+b);

        if(b > 1) {
            extractor(a);
        }

        String result = asNumbers(a);
        return result;
    }

    static void extractor(int n) {
        System.out.print(" = "+ n +"+1+1");
//        if(n > 1){
//            extractor(n - 1);
//        }
    }






}
// 5 =
// 4+1 =
// 3+2 =
// 3+1+1 =
// 2+2+1 =
// 2+1+1+1 =
// 1+1+1+1+1


// n - входящее в цикл |5
// k - входит в цикл   |1

// j = n - 1           |4
// вывести "= j"       |"= 4"
// (k < n)             |1
// вывести "+ 1"       |"+ 1"
// подитог             |" = 4 + 1"
//
// n - входящее в цикл |4
// k - входит в цикл   |1
//                     |5

// 5  5

// 4 = 5 - 1
// echo              |" = 4"
// 1 = 5 - 4         |1
// echo              |" = 4 + 1"

// 4  5

// 3 = 4 - 1
// echo              |" = 3"
// 2 = 5 - 3         |2
// echo              |" = 3 + 2"

//

