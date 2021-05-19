package ru.training.at.hw4.ex1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw4.WebPageTestsBase;
import ru.training.at.hw4.pages.MainPage;
import ru.training.at.hw4.steps.MainPageSteps;

@Feature("Jdi testing website. Home page")
@Story("Log in")
//@Listeners(Listener_Demo.ListenerTest.class)
public class MainPageTests extends WebPageTestsBase {
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
        headerTests();
        benefitsTest();
        frameTests();
        sidebarMenuTests();

        softAssert.assertAll();
    }

    private void openPageTests() {
        //1 Open test site by URL
        mainPageSteps.openPage();

        // 2 Assert Browser title "Home Page"
        mainPageSteps.assertBrowserTitle("Home Page");
    }

    private void loginTests() {
        // 3 Perform login username: Roman pass: Jdi1234
        mainPageSteps.logiIn("Roman", "Jdi1234");

        // 4 Assert Username is loggined "ROMAN IOVLEV"
        mainPageSteps.assertUsername("ROMAN IOVLEV");
    }

    private void headerTests() {
        // 5 Assert that there are 4 items on the header section are displayed and they have
        // proper texts
        // "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        mainPageSteps.assertHeaderItemsSize(4);
        mainPageSteps.assertHeaderItemsText("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    }

    private void benefitsTest() {
        // 6
        // Assert that there are 4 images on the Index Page and they are displayed
        mainPageSteps.assertBenefitsIcons(4);
        // 7
        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        mainPageSteps.assertBenefitsIconsText();
    }

    private void frameTests() {
        // 8 Assert that there is the iframe with “Frame Button” exist
        mainPageSteps.assertIsFrameWithButtonExists();
        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        mainPageSteps.assertSwitchToFrameWithButton();
        // 10 Switch to original window back
        mainPageSteps.switchBackToWindow();
    }

    private void sidebarMenuTests() {
        // 11 Assert that there are 5 items in the Left Section are displayed and they have
        // proper text
        // “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        mainPageSteps.assertLeftSectionItems();
    }
}
