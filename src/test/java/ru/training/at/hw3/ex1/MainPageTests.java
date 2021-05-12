package ru.training.at.hw3.ex1;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw3.WebdriverTestsBase;
import ru.training.at.hw3.pages.MainPage;

import java.util.List;

public class MainPageTests extends WebdriverTestsBase {
    MainPage page;

    @BeforeMethod(alwaysRun = true)
    public void initPage() {
        page = new MainPage(webDriver);
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
        page.openPage();

        // 2 Assert Browser title "Home Page"
        softAssert.assertEquals("Home Page", page.getTitle(), "Wrong page title");
    }

    private void loginTests() {
        // 3 Perform login username: Roman pass: Jdi1234
        page.logiIn("Roman", "Jdi1234");

        // 4 Assert Username is loggined "ROMAN IOVLEV"
        softAssert.assertEquals(page.getUserName(), "ROMAN IOVLEV", "Wrong User name");
    }

    private void headerTests() {
        // 5 Assert that there are 4 items on the header section are displayed and they have
        // proper texts
        // "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        softAssert.assertEquals(page.headerItems().size(), 4, "Wrong items count in the header");
        softAssert.assertNotNull(page.getHeaderItem("HOME"),
                "The item \"HOME\" does not exist in the header");
        softAssert.assertNotNull(page.getHeaderItem("CONTACT FORM"),
                "The item \"CONTACT FORM\" does not exist in the header");
        softAssert.assertNotNull(page.getHeaderItem("SERVICE"),
                "The item \"SERVICE\" does not exist in the header");
        softAssert.assertNotNull(page.getHeaderItem("METALS & COLORS"),
                "The item \"METALS & COLORS\" does not exist in the header");
    }

    private void benefitsTest() {
        // 6
        // Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = page.benefitIcons;
        softAssert.assertEquals(images.size(), 4, "Wrong benefit icons count");
        for (WebElement img : images) {
            softAssert.assertTrue(img.isDisplayed());
        }
        // 7
        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertNotNull(page.benefitTextItem(
                "To include good practices\nand ideas from successful\nEPAM project"));
        softAssert.assertNotNull(page.benefitTextItem("To be flexible and\ncustomizable"));
        softAssert.assertNotNull(page.benefitTextItem("To be multiplatform"));
        softAssert.assertNotNull(page.benefitTextItem("Already have good base"
                + "\n(about 20 internal and\nsome external projects),"
                + "\nwish to get more…"));
    }

    private void frameTests() {
        // 8 Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(page.isFrameWithButtonExists(),
                "The frame with button does not exist");
        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        boolean isButtonExists = page.switchToFrameWithButton()
                .isButtonExists();
        softAssert.assertTrue(isButtonExists);
        // 10 Switch to original window back
        page.switchBack();
    }

    private void sidebarMenuTests() {
        // 11 Assert that there are 5 items in the Left Section are displayed and they have
        // proper text
        // “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        softAssert.assertEquals(page.sidebarMenuItems().size(), 5);
        softAssert.assertNotNull(page.sidebarMenuItem("Home"));
        softAssert.assertNotNull(page.sidebarMenuItem("Contact form"));
        softAssert.assertNotNull(page.sidebarMenuItem("Service"));
        softAssert.assertNotNull(page.sidebarMenuItem("Metals & Colors"));
        softAssert.assertNotNull(page.sidebarMenuItem("Elements packs"));
    }
}
