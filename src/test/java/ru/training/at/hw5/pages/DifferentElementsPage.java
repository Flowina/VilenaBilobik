package ru.training.at.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage extends JdiTestingPage {
    private static final String URL = "https://jdi-testing.github.io/jdi-light/different-elements.html";

    @FindBy(css = ".colors select option")
    private List<WebElement> listColors;

    @FindBy(css = ".colors select")
    private WebElement colorsDropdownField;

    @FindBy(className = "label-radio")
    private List<WebElement> metalRadiobuttons;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkBoxes;

    @FindBy(css = ".logs li")
    private List<WebElement> logItems;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    protected String getUrl() {
        return URL;
    }

    public void selectCheckboxes(String... names) {
        for (String name : names) {
            for (WebElement x : checkBoxes) {
                if (x.getText().equals(name)) {
                    x.click();
                    break;
                }
            }
        }
    }

    public void selectRadio(String... names) {
        for (String name : names) {
            for (WebElement x : metalRadiobuttons) {
                if (x.getText().equals(name)) {
                    x.click();
                    break;
                }
            }
        }
    }

    public void selectInDropdown(String... names) {
        colorsDropdownField.click();

        for (String name : names) {
            for (WebElement x : listColors) {
                if (x.getText().equals(name)) {
                    x.click();
                    break;
                }
            }
        }
    }

    public boolean isLogContainsString(String substring) {
        for (WebElement x : logItems) {
            if (x.getText().contains(substring)) {
                return true;
            }
        }
        return false;
    }
}

