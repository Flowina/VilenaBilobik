package ru.training.at.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class WebPageTestsBase {
    protected WebDriver webDriver;
    protected SoftAssert softAssert;

    @BeforeClass(alwaysRun = true)
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    protected void initWebdriver(ITestContext context) {
        softAssert = new SoftAssert();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().deleteAllCookies();

        context.setAttribute("driver", webDriver);
    }

    @AfterMethod(alwaysRun = true)
    protected void closeWebdriver() {
        softAssert = null;
        // 12 Close Browser
        if (webDriver != null) {
            webDriver.close();
            webDriver = null;
        }
    }
}
