package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiplyTests extends BaseCalculatorTests {
    @DataProvider
    public Object[][] dataLongs() {
        return new Object[][]{
                {0L, 10L, 0L},
                {5L, 10L, 50L},
                {-5L, 1L, -5L},
        };
    }

    @DataProvider
    public Object[][] dataDoubles() {
        return new Object[][]{
                {1.1, 10, 11},
                {0.5, 0.5, 0.25},
                {-5, 7.5, 37.5},
        };
    }

    @Test(dataProvider = "dataLongs",
            groups = {Tags.MULTIPLY})
    public void multiplyLongsTest(long a, long b, long expected) {
        long result = calculator.mult(a, b);
        Assert.assertEquals(result, expected, "wrong multiply of longs");
    }

    @Test(dataProvider = "dataDoubles",
            groups = {Tags.MULTIPLY})
    public void multiplyLongsTest(double a, double b, double expected) {
        double result = calculator.mult(a, b);
        Assert.assertEquals(result, expected,
                String.format("wrong multiply of doubles: %f * %f", a, b));
    }
}
