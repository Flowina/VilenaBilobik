package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubtractOperationTests extends BaseCalculatorTests {
    @DataProvider
    public Object[][] dataLong() {
        return new Object[][]{
                {0L, 10L, -10L},
                {5L, 10L, -5L},
                {-5L, 1L, -6L},
                {5L, 1L, 4L},
        };
    }

    @DataProvider
    public Object[][] dataDoubles() {
        return new Object[][]{
                {1.1, 10, -8.9},
                {0.5, 0.5, 0},
                {-5.0, 7.5, -12.5},
        };
    }

    @Test(dataProvider = "dataLong",
            groups = {Tags.SUBTRACT})
    public void subtractLongsTest(long a, long b, long expected) {
        long subs = calculator.sub(a, b);
        Assert.assertEquals(subs, expected, "wrong subtract of longs");
    }

    @Test(dataProvider = "dataDoubles",
            groups = {Tags.SUBTRACT})
    public void subtractDoublesTest(double a, double b, double expected) {
        double subs = calculator.sub(a, b);
        Assert.assertEquals(subs, expected,
                String.format("wrong subtract of doubles: %f * %f", a, b));
    }
}
