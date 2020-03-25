package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.calc.SimpleCalculator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestSimpleCalculatorTestDiff {

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
                {1, 1, 0},
                {1000, 6, 994},
                {2, 20, -18},
        });
    }

    @Test
    public void test() {
        int result = simpleCalculator.diff(val1, val2);
        assertEquals(result, expected);
    }
}
