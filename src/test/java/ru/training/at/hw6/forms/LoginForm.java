package ru.training.at.hw6.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ru.training.at.hw6.entities.User;

public class LoginForm extends Form<User> {
    @UI("#name")
    public TextField name;

    @UI("#password")
    public TextField password;

    @UI("#login-button")
    public TextField submit;
}
