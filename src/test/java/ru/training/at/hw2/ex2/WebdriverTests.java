package ru.training.at.hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.training.at.hw2.WebdriverTestsBase;

import java.util.List;

public class WebdriverTests extends WebdriverTestsBase {
    @Test
    public void testDifferentElementsPage() {
        // 1 Open test site by URL https://jdi-testing.github.io/jdi-light/index.html
        // 2 Assert Browser title "Home Page"
        openSiteTest();

        //3 Perform login username: Roman
        // pass: Jdi1234
        // 4 Assert User name in the left-top side of screen that user is loggined ROMAN IOVLEV
        loginTest();


        //  5 Open through the header menu Service -> Different Elements Page
        navigateToDifferentElementsPage();

        // 6 Select checkboxes Water, Wind
        selectCheckboxes("Water", "Wind");

        // 7 Select radio Selen
        selectRadio("Selen");

        // 8 Select in dropdown Yellow
        selectInDropdown("Yellow");

        // 9 Assert that
        //• for each checkbox there is an individual log row and value is
        // corresponded to the status of checkbox
        assertCheckboxesLogs("Water", "Wind");
        //• for radio button there is a log row and value is
        // corresponded to the status of radio button
        assertRadioLogs("Selen");
        //• for dropdown there is a log row and value is corresponded to the selected value.
        assertDropdownLogs("Yellow");

        softAssert.assertAll();
    }

    private void assertRadioLogs(String... names) {
        List<WebElement> logElements = webDriver.findElements(By.cssSelector(".logs li"));
        for (String name :
                names
        ) {
            boolean success = false;
            for (WebElement logElement
                    : logElements
            ) {
                if (logElement
                        .getText()
                        .contains(String.format("metal: value changed to %s", name))) {
                    success = true;
                    break;
                }
            }
            softAssert.assertTrue(success,
                    String.format("log doesn't contain row with radio %s", name));
        }
    }

    private void assertDropdownLogs(String... names) {
        List<WebElement> logElements = webDriver.findElements(By.cssSelector(".logs li"));
        for (String name :
                names
        ) {
            boolean success = false;
            for (WebElement logElement
                    : logElements
            ) {
                if (logElement
                        .getText()
                        .contains(String.format("Colors: value changed to %s", name))) {
                    success = true;
                    break;
                }
            }
            softAssert.assertTrue(success,
                    String.format("log doesn't contain row with color %s", name));
        }
    }

    private void assertCheckboxesLogs(String... names) {
        List<WebElement> logElements = webDriver.findElements(By.cssSelector(".logs li"));
        for (String name :
                names
        ) {
            boolean success = false;
            for (WebElement logElement
                    : logElements
            ) {
                if (logElement
                        .getText()
                        .contains(String.format("%s: condition changed to true", name))) {
                    success = true;
                    break;
                }
            }
            softAssert.assertTrue(success,
                    String.format("log doesn't contain row with checkbox %s", name));
        }
    }

    private void selectCheckboxes(String... names) {
        String template = "//label[@class='label-checkbox' and contains(., '${name}')]";
        for (String name : names
        ) {
            webDriver.findElement(
                    By.xpath(template.replace("${name}", name)))
                    .click();
        }
    }

    private void selectRadio(String... names) {
        String template = "//label[@class='label-radio' and contains(., '${name}')]";
        for (String name : names
        ) {
            webDriver.findElement(By.xpath(template.replace("${name}", name)))
                    .click();
        }
    }

    private void selectInDropdown(String... names) {
        for (String name :
                names) {
            webElement = webDriver.findElement(By.cssSelector(".colors select"));
            webElement.click();

            webElement.findElement(By.xpath(String.format("//option[text()='%s']", name))).click();
        }
    }

    private void navigateToDifferentElementsPage() {
        webDriver.findElement(By.linkText("Service")).click();
        webDriver.findElement(By.linkText("Different elements")).click();

        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.urlContains("different-elements.html"),
                ExpectedConditions.visibilityOfElementLocated(By.className("main-content"))
        ));
        softAssert.assertEquals(webDriver.getTitle(), "Different Elements");
    }
}
