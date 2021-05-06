package ru.training.at.hw1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorAddOperationTests extends BaseCalculatorTests {
    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {0L, 10L, 10L},
                {5L, 10L, 15L},
                {-5L, 1L, -4L},
        };
    }

    @Test(dataProvider = "data",
            groups = {Tags.ADD})
    public void addIntegersTest(long a, long b, long expected) {
        long sum = calculator.sum(a, b);
        Assert.assertEquals(sum, expected, "wrong sum of integers");
    }

    @Test(expectedExceptions = Exception.class,
            groups = {Tags.ADD})
    public void addMaxLongTest() {
        long sum = calculator.sum(Long.MAX_VALUE, Long.MAX_VALUE);
    }
}
