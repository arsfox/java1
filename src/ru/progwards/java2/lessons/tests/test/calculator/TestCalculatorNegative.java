package ru.progwards.java2.lessons.tests.test.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.calculator.Calculator;

import static org.junit.Assert.assertEquals;

public class TestCalculatorNegative {

    @Test(expected = Exception.class)
    public void test() throws Exception {
        Calculator.calculate("1+(2+3)*2+(1+1");
    }

}
