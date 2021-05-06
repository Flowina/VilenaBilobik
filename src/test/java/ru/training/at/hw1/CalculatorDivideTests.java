package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorDivideTests extends BaseCalculatorTests {
    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {0L, 10L, 0L},
                {5L, 10L, 0L},
                {-5L, 1L, -5L},
        };
    }

    @Test(dataProvider = "data",
        groups = {Tags.DIVIDE})
    public void divideIntegersTest(long a, long b, long expected) {
        long div = calculator.div(a, b);
        Assert.assertEquals(div, expected, "wrong divide of integers");
    }

    @Test(expectedExceptions = NumberFormatException.class,
        expectedExceptionsMessageRegExp = "Attempt to divide by zero",
        groups = {Tags.DIVIDE})
    public void divisionByZeroTest() {
        calculator.div(1, 0);
    }
}
