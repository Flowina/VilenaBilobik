package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import ru.training.at.hw6.entities.MetalsAndColorsDataItem;

public class MetalsAndColorsForm extends Form<MetalsAndColorsDataItem> {
    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "#salad-dropdown",
            list = "li",
            expand = ".caret")
    public Dropdown vegetables;

    @UI("#elements-checklist input[type=checkbox]")
    public static Checklist elements;

    @UI("input[name=custom_radio_even]")
    public RadioButtons summaryEven;

    @UI("input[name=custom_radio_odd]")
    public RadioButtons summaryOdd;

    @UI("#submit-button")
    public static Button submitButton;

    @Override
    public void submit() {
        submitButton.click();
    }
}
