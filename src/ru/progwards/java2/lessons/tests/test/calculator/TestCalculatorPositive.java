package ru.progwards.java2.lessons.tests.test.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.calculator.Calculator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestCalculatorPositive {

    @Parameterized.Parameter()
    public String expression;

    @Parameterized.Parameter(1)
    public int expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"1+1", 2},
                {"(1+1)*3", 6},
                {"1+1*3", 4},
                {"1+1/2", 1},
                {"1+1-2", 0},
                {"1+(2+3)*2+(1+1)", 13}
        });
    }

    @Test
    public void test() throws Exception {
        int result = Calculator.calculate(expression);
        assertEquals(result, expectedResult);
    }

}
