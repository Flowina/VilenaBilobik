package ru.training.at.hw7.ex2;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw7.WebPageTestsBase;
import ru.training.at.hw7.pages.DifferentElementsPage;
import ru.training.at.hw7.pages.MainPage;

public class DifferentElementsPageTests extends WebPageTestsBase {
    MainPage mainPage;
    DifferentElementsPage differentElementsPage;

    @BeforeMethod(alwaysRun = true)
    public void initPages() {
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Test
    public void testDifferentElementsPage() {
        openSiteTest();
        loginTest();
        navigateToDifferentElementsPage();
        // 6 Select checkboxes Water, Wind
        differentElementsPage.selectCheckboxes("Water", "Wind");

        // 7 Select radio Selen
        differentElementsPage.selectRadio("Selen");

        // 8 Select in dropdown Yellow
        differentElementsPage.selectInDropdown("Yellow");

        // 9 Assert that
        assertLogs();

        softAssert.assertAll();
    }

    private void openSiteTest() {
        // 1 Open test site by URL https://jdi-testing.github.io/jdi-light/index.html
        mainPage.openPage();
        // 2 Assert Browser title "Home Page"
        softAssert.assertEquals(mainPage.getTitle(), "Home Page", "Wrong title");
    }

    private void loginTest() {
        //3 Perform login username: Roman
        // pass: Jdi1234
        mainPage.logiIn("Roman", "Jdi1234");
        // 4 Assert User name in the left-top side of screen that user is loggined ROMAN IOVLEV
        softAssert.assertEquals(mainPage.getUserName(), "ROMAN IOVLEV", "Wrong UserName");
    }

    private void navigateToDifferentElementsPage() {
        //  5 Open through the header menu Service -> Different Elements Page
        mainPage.clickOnMenuServiceItem("Different elements");
        softAssert.assertEquals(differentElementsPage.getTitle(), "Different Elements");
    }

    private void assertLogs() {
        final String checkboxLogTemplate = "%s: condition changed to true";
        final String radioLogTemplate = "metal: value changed to %s";
        final String dropdownLogTemplate = "Colors: value changed to %s";

        // for each checkbox there is an individual log row and value is
        // corresponded to the status of checkbox
        softAssert.assertTrue(
                differentElementsPage
                        .isLogContainsString(String.format(checkboxLogTemplate, "Water")));
        softAssert.assertTrue(
                differentElementsPage
                        .isLogContainsString(String.format(checkboxLogTemplate, "Wind")));

        // for radio button there is a log row and value is
        // corresponded to the status of radio button
        softAssert.assertTrue(
                differentElementsPage
                        .isLogContainsString(String.format(radioLogTemplate, "Selen")));

        // for dropdown there is a log row and value is corresponded to the selected value.
        softAssert.assertTrue(
                differentElementsPage
                        .isLogContainsString(String.format(dropdownLogTemplate, "Yellow")));
    }
}
