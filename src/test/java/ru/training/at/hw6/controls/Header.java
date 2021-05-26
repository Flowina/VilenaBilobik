package ru.training.at.hw6.controls;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

@UI(".uui-header")
public class Header extends Section {
    @UI("ul.navbar-nav.m-l8 a")
    public Menu menu;
}

