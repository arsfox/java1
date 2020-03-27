package ru.progwards.java2.lessons.tests.test.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.calculator.Calculator;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class TestCalculatorNegative {

    @Parameterized.Parameter()
    public String expression;

    @Parameterized.Parameters
    public static List<Object> data() {
        return Arrays.asList(new Object[]{
              "1+(2+3)*2+(1+1",
              "1&1",
              "(3+(1+1)+3"
        });
    }

    @Test(expected = Exception.class)
    public void test() throws Exception {
        Calculator.calculate(expression);
    }



}
