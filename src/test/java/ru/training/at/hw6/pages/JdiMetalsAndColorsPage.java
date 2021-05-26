package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import org.openqa.selenium.WebElement;
import ru.training.at.hw6.entities.MetalsAndColorsDataItem;
import ru.training.at.hw6.forms.MetalsAndColorsForm;

import java.util.LinkedList;
import java.util.List;

@Url("/metals-colors.html")
public class JdiMetalsAndColorsPage extends WebPage {
    @UI(".main-content form")
    public MetalsAndColorsForm metalsAndColorsForm;

    @UI(".info-panel-body-result .results li")
    public static List<WebElement> results;

    public void fillMetalsAndColorsForm(MetalsAndColorsDataItem data) {
        metalsAndColorsForm.summaryOdd.select(data.getSummaryOdd());
        metalsAndColorsForm.summaryEven.select(data.getSummaryEven());
        metalsAndColorsForm.elements.select(data.elements);
        metalsAndColorsForm.colors.select(data.color);
        metalsAndColorsForm.metals.select(data.metals);

        metalsAndColorsForm.vegetables.expand();
        metalsAndColorsForm.vegetables.select(data.vegetables);
    }

    public void submitMetalAndColorForm() {
        metalsAndColorsForm.submit();
    }

    public List<String> getResultLines() {
        List<String> lines = new LinkedList<>();
        for (WebElement element : results) {
            lines.add(element.getText());
        }
        return lines;
    }
}
