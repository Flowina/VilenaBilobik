package ru.training.at.hw6;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import ru.training.at.hw6.controls.HeaderMenu;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.pages.JdiMainPage;
import ru.training.at.hw6.pages.JdiMetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiTestingSite {
    @Url("index.html")
    public static JdiMainPage mainPage;

    @Url("/metals-colors.html")
    public static JdiMetalsAndColorsPage metalsAndColorsPage;

    public static HeaderMenu headerMenu;

    @Css(".profile-photo [ui=label]")
    public static UIElement userName;

    @Css(".logout button")
    public static Button logout;

    public static void open() {
        mainPage.open();
    }

    public static void login(User user) {
        mainPage.login(user);
    }

    public static void openMetalsAndColorsPage() {
        headerMenu.select("Metals & Colors");
    }

    public static void logout() {
        if (!logout.isDisplayed()) {
            userName.click();
        }
        logout.click();
    }
}
