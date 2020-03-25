package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.calc.SimpleCalculator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestSimpleCalculatorTestDiv {

    SimpleCalculator simpleCalculator = new SimpleCalculator();

    @Parameterized.Parameter()
    public int val1;
    @Parameterized.Parameter(1)
    public int val2;
    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1},
                {150, 50, 3},
                {-150, 50, -3}
        });
    }

    @Test
    public void test() {
        int result = simpleCalculator.div(val1, val2);
        assertEquals(result, expected);
    }

    @Test(expected = ArithmeticException.class)
    public void testZro() {
        int result = simpleCalculator.div(0, 0);
        assertEquals(result, 0);
    }
}
