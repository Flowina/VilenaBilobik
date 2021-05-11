package ru.training.at.hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.training.at.hw2.WebdriverTestsBase;

import java.util.List;

public class WebdriverTests extends WebdriverTestsBase {
    @Test
    public void testMainPage() {
        openSiteTest();
        loginTest();
        headerTest();
        benefitsTest();
        fraimTest();
        sideBarMenuTest();

        softAssert.assertAll();
    }


    private void headerTest() {
        // 5 Assert that there are 4 items on the header section are displayed and they have
        // proper texts
        // "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
        String[] navigationLinks = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        for (String linkText : navigationLinks) {
            webElement = webDriver.findElement(By.linkText(linkText));
            softAssert.assertNotNull(webElement);
        }
    }


    private void benefitsTest() {

        WebElement benefitsContainer = webDriver.findElement(By.className("benefits"));
        List<WebElement> benefits = benefitsContainer.findElements(By.className("benefit"));
        // 6
        // Assert that there are 4 images on the Index Page and they are displayed 4 images
        softAssert.assertTrue(benefits.size() == 4);

        String benifitLocatorTemplate =
                "//*[@class='benefit' and .//*[contains(@class, '${imgClass}')]]";
        checkBenefitBlock(By.xpath(benifitLocatorTemplate.replace("${imgClass}", "icon-practise")),
                "To include good practices\nand ideas from successful\nEPAM project",
                benefitsContainer);
        checkBenefitBlock(
                By.xpath(benifitLocatorTemplate.replace("${imgClass}", "icon-custom")),
                "To be flexible and\ncustomizable",
                benefitsContainer);
        checkBenefitBlock(
                By.xpath(benifitLocatorTemplate.replace("${imgClass}", "icon-multi")),
                "To be multiplatform",
                benefitsContainer);
        checkBenefitBlock(
                By.xpath(benifitLocatorTemplate.replace("${imgClass}", "icon-base")),
                "Already have good base"
                        + "\n(about 20 internal and\nsome external projects),"
                        + "\nwish to get more…",
                benefitsContainer);
    }

    private void checkBenefitBlock(By benefitLocator, String expectedText, WebElement parent) {
        WebElement benefitElement = parent.findElement(benefitLocator);
        // 6
        // find image in the container
        webElement = benefitElement.findElement(By.className("icons-benefit"));
        //Assert image is displayed
        softAssert.assertTrue(webElement.isDisplayed());

        // 7
        // find text under the image
        webElement = benefitElement.findElement(By.className("benefit-txt"));
        // Assert the text have proper value
        softAssert.assertEquals(webElement.getText(), expectedText);
    }

    private void fraimTest() {
        // 8 Assert that there is the iframe with “Frame Button” exist
        WebElement frame = webDriver.findElement(By.id("frame"));
        softAssert.assertTrue(webElement.isDisplayed());

        // 9 Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(frame);
        webElement = webDriver.findElement(By.id("frame-button"));
        softAssert.assertEquals(webElement.getAttribute("value"),
                "Frame Button");

        // 10 Switch to original window back
        webDriver.switchTo().parentFrame();
    }

    private void sideBarMenuTest() {
        // 11 Assert that there are 5 items in the Left Section are displayed and they have
        // proper text
        // “Home”, “Contact form”, “Service”, “Metals & Colors”, “Elements packs”
        String[] itemNames
                = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        WebElement container = webDriver.findElement(By.cssSelector(".sidebar-menu.left"));
        for (String name : itemNames) {
            webElement = container.findElement(By.linkText(name));
            softAssert.assertEquals(webElement.getText(), name);
        }
    }
}
