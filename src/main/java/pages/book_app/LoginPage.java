package pages.book_app;

import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

public class LoginPage implements BasePage {
    public final SelenideElement usernameInputField = getElementById("userName");
    public final SelenideElement passwordInputField = getElementById("password");
    public final SelenideElement loginButton = getElementById("login");

    public final SelenideElement newUserButton = getElementById("newUser");
}
