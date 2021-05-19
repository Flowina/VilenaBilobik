package ru.training.at.hw4.ex1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw4.WebPageTestsBase;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.pages.MainPage;
import ru.training.at.hw4.steps.DifferentElementsPageSteps;
import ru.training.at.hw4.steps.MainPageSteps;

@Feature("Jdi testing website. Different Elements page")
@Story("Select metals")
@Story("Select colors")
@Story("Select elements")
public class DifferentElementsPageTests extends WebPageTestsBase {
    MainPage mainPage;
    DifferentElementsPage differentElementsPage;
    MainPageSteps mainPageSteps;
    DifferentElementsPageSteps differentPageSteps;

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        mainPageSteps = new MainPageSteps(mainPage, softAssert);
        differentPageSteps = new DifferentElementsPageSteps(differentElementsPage, softAssert);
    }

    @Test
    public void testDifferentElementsPage() {
        openSiteTest();
        loginTest();
        navigateToDifferentElementsPage();
        // 6 Select checkboxes Water, Wind
        differentPageSteps.selectCheckboxes("Water", "Wind");
        // 7 Select radio Selen
        differentPageSteps.selectRadio("Selen");
        // 8 Select in dropdown Yellow
        differentPageSteps.selectDropdown("Yellow");
        // 9 Assert that
        differentPageSteps.assertLogs("Water", "Wind", "Selen", "Yellow");

        softAssert.assertAll();
    }

    private void openSiteTest() {
        // 1 Open test site by URL https://jdi-testing.github.io/jdi-light/index.html
        mainPageSteps.openPage();
        // 2 Assert Browser title "Home Page"
        mainPageSteps.assertBrowserTitle("Home Page");
    }

    private void loginTest() {
        // 3 Perform login username: Roman pass: Jdi1234
        mainPageSteps.logiIn("Roman", "Jdi1234");

        // 4 Assert Username is loggined "ROMAN IOVLEV"
        mainPageSteps.assertUsername("ROMAN IOVLEV");
    }

    private void navigateToDifferentElementsPage() {
        //  5 Open through the header menu Service -> Different Elements Page
        mainPageSteps.navigateToDifferentElementsPage();
        differentPageSteps.assertBrowserTitle("Different Elements");
    }
}
