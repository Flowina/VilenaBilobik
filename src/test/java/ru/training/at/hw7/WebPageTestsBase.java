package ru.training.at.hw7;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw7.webdriver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public abstract class WebPageTestsBase {
    protected WebDriver webDriver;
    protected SoftAssert softAssert;

    @BeforeMethod(alwaysRun = true)
    protected void initWebdriver() {
        softAssert = new SoftAssert();
        webDriver = WebDriverFactory.createWebDriver(System.getProperty("browser.name"));
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();
    }

    @AfterMethod(alwaysRun = true)
    protected void closeWebdriver() {
        softAssert = null;
        // 12 Close Browser
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
