package actions.book_app;

import pages.book_app.LoginPage;

public class LoginPageActions {
    private LoginPage loginPage = new LoginPage();

    public void clickLoginButton() {
        loginPage.loginButton.click();
    }

    public void clickNewUserButton() {
        loginPage.newUserButton.click();
    }

    public void fillLoginForm(String username, String password) {
        inputDataInUsernameField(username);
        inputDataInPasswordField(password);
    }

    public void inputDataInUsernameField(String data) {
        loginPage.usernameInputField.sendKeys(data);
    }

    public void inputDataInPasswordField(String data) {
        loginPage.passwordInputField.sendKeys(data);
    }
}
