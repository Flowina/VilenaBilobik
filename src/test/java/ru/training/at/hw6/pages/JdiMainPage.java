package ru.training.at.hw6.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.LoginForm;

public class JdiMainPage extends WebPage {
    @FindBy(id = "login-form")
    public LoginForm loginForm;

    @FindBy(id = "user-icon")
    public Icon userIcon;

    @FindBy(id = "user-name")
    public Label userNameLabel;

    public void login(User user) {
        userIcon.click();
        loginForm.submit(user);
    }

    public String getUserName() {
        return userNameLabel.getText();
    }
}
