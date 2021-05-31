package ru.training.at.hw7.ex1;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw7.WebPageTestsBase;
import ru.training.at.hw7.pages.MainPage;

import java.util.List;

public class MainPageTests extends WebPageTestsBase {
    MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void initPage() {
        mainPage = new MainPage(webDriver);
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
        mainPage.openPage();

        // 2 Assert Browser title "Home Page"
        softAssert.assertEquals("Home Page", mainPage.getTitle(), "Wrong page title");
    }

    private void loginTests() {
        // 3 Perform login username: Roman pass: Jdi1234
        mainPage.logiIn("Roman", "Jdi1234");

        // 4 Assert Username is loggined "ROMAN IOVLEV"
        softAssert.assertEquals(mainPage.getUserName(), "ROMAN IOVLEV", "Wrong User name");
    }

    private void headerTests() {
        // 5 Assert that there are 4 items on the header section are displayed and they have
        // proper texts
        // "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        softAssert.assertEquals(mainPage.headerItems().size(),
                4, "Wrong items count in the header");
        softAssert.assertNotNull(mainPage.getHeaderItem("HOME"),
                "The item \"HOME\" does not exist in the header");
        softAssert.assertNotNull(mainPage.getHeaderItem("CONTACT FORM"),
                "The item \"CONTACT FORM\" does not exist in the header");
        softAssert.assertNotNull(mainPage.getHeaderItem("SERVICE"),
                "The item \"SERVICE\" does not exist in the header");
        softAssert.assertNotNull(mainPage.getHeaderItem("METALS & COLORS"),
                "The item \"METALS & COLORS\" does not exist in the header");
    }

    private void benefitsTest() {
        // 6
        // Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = mainPage.benefitIcons;
        softAssert.assertEquals(images.size(), 4, "Wrong benefit icons count");
        for (WebElement img : images) {
            softAssert.assertTrue(img.isDisplayed());
        }
        // 7
        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertNotNull(mainPage.benefitTextItem(
                "To include good practices\nand ideas from successful\nEPAM project"));
        softAssert.assertNotNull(mainPage.benefitTextItem("To be flexible and\ncustomizable"));
        softAssert.assertNotNull(mainPage.benefitTextItem("To be multiplatform"));
        softAssert.assertNotNull(mainPage.benefitTextItem("Already have good base"
                + "\n(about 20 internal and\nsome external projects),"
                + "\nwish to get more…"));
    }

    private void frameTests() {
        // 8 Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(mainPage.isFrameWithButtonExists(),
                "The frame with button does not exist");
        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        mainPage.switchToFrameWithButton();
        boolean isButtonExists = mainPage.isButtonExists();
        softAssert.assertTrue(isButtonExists);
        // 10 Switch to original window back
        mainPage.switchBack();
    }

    private void sidebarMenuTests() {
        // 11 Assert that there are 5 items in the Left Section are displayed and they have
        // proper text
        // “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        softAssert.assertEquals(mainPage.sidebarMenuItems().size(), 5);
        softAssert.assertNotNull(mainPage.sidebarMenuItem("Home"));
        softAssert.assertNotNull(mainPage.sidebarMenuItem("Contact form"));
        softAssert.assertNotNull(mainPage.sidebarMenuItem("Service"));
        softAssert.assertNotNull(mainPage.sidebarMenuItem("Metals & Colors"));
        softAssert.assertNotNull(mainPage.sidebarMenuItem("Elements packs"));
    }
}
