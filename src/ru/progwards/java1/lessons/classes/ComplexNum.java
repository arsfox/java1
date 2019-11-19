package ru.progwards.java1.lessons.classes;

public class ComplexNum {

    int a, b;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public ComplexNum add(ComplexNum num1, ComplexNum num2) {
        return new ComplexNum((num1.a + num2.a), (num1.b + num2.b));
    }

    public ComplexNum sub(ComplexNum num1, ComplexNum num2) {
        return new ComplexNum((num1.a - num2.a), (num1.b - num2.b));
    }

    public ComplexNum mul(ComplexNum num1, ComplexNum num2) {
        int a = num1.a;
        int b = num1.b;
        int c = num2.a;
        int d = num2.b;
        return new ComplexNum(((a * c - b * d)), (b * c + a * d));
    }

    public ComplexNum div(ComplexNum num1, ComplexNum num2) {
        int a = num1.a;
        int b = num1.b;
        int c = num2.a;
        int d = num2.b;
        return new ComplexNum(((a * c + b * d)/(c * c+d * d)), (((b * c - a * d )/(c * c + d * d))));
    }

    public String toString() {
        if(b < 0){
            return a+""+b+"i";
        } else {
            return a+"+"+b+"i";
        }

    }
}
