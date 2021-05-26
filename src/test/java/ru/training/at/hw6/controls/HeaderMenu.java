package ru.training.at.hw6.controls;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

@UI(".uui-header")
public class HeaderMenu extends Section {
    @UI("ul.navbar-nav.m-l8 a")
    public static Menu headerMenu;

    public void select(String name) {
        headerMenu.select(name);
    }
}

