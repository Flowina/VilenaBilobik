package ru.training.at.hw5.steps.cucumber;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;
import ru.training.at.hw5.context.TestContext;

import static ru.training.at.hw5.context.TestContext.ASSERTION;
import static ru.training.at.hw5.context.TestContext.WEB_DRIVER;

public abstract class CommonCucumberSteps {
    protected final Assertion assertion;
    protected final WebDriver driver;

    protected CommonCucumberSteps() {
        driver = TestContext.getInstance().getTestObject(WEB_DRIVER);
        assertion = TestContext.getInstance().getTestObject(ASSERTION);
    }
}
