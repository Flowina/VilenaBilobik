package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw5.context.TestContext;

import java.util.concurrent.TimeUnit;

public class WebDriverHook {
    private WebDriver webDriver;
    private Assertion softAssert;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();

        TestContext.getInstance().setTestObject(TestContext.WEB_DRIVER, webDriver);

        softAssert = new SoftAssert();
        TestContext.getInstance().setTestObject(TestContext.ASSERTION, softAssert);
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.close();
            webDriver = null;
        }
        softAssert = null;

        TestContext.getInstance().cleanContext();
    }
}