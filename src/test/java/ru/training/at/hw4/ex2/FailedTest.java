package ru.training.at.hw4.ex2;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw4.WebPageTestsBase;
import ru.training.at.hw4.pages.MainPage;
import ru.training.at.hw4.steps.MainPageSteps;

import java.util.List;

@Feature("Jdi testing website. Home page")
@Story("Log in")
public class FailedTest extends WebPageTestsBase {
    MainPageSteps mainPageSteps;
    MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void initPage() {
        mainPage = new MainPage(webDriver);
        mainPageSteps = new MainPageSteps(mainPage, softAssert);
    }

    @Test
    public void testMainPage() {
        openPageTests();
        loginTests();
        softAssert.assertAll();
    }

    private void openPageTests() {
        //1 Open test site by URL
        //mainPage.openPage();
        mainPageSteps.openPage();

        // 2 Assert Browser title "Home Page"
        softAssert.assertEquals("Home Page", mainPage.getTitle(), "Wrong page title");
    }

    private void loginTests() {
        // 3 Perform login username: Roman pass: Jdi1234
        mainPageSteps.logiIn("Roman", "Jdi1234");
        //mainPage.logiIn("Roman", "Jdi1234");

        // 4 Assert Username is loggined "ROMAN IOVLEV"
        softAssert.assertEquals(mainPage.getUserName(), "ROMAN IOVLEV1", "Wrong User name");
    }
}
