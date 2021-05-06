package ru.training.at.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseCalculatorTests {
    protected Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        calculator = null;
    }
}
