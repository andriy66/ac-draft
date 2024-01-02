package ui.book_app;

import actions.MainPageActions;
import actions.book_app.BookAppPageActions;
import actions.book_app.LoginPageActions;
import actions.book_app.ProfilePageActions;
import base.ConfigReader;
import components.Cards;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.book_app.BookAppPage;
import ui.BaseTest;

public class LoginTests extends BaseTest {
    private final String PASSWORD = ConfigReader.PASSWORD.getParameterValue();
    private final String USERNAME = ConfigReader.USERNAME.getParameterValue();
    private final LoginPageActions loginPageActions = new LoginPageActions();
    private final ProfilePageActions profilePageActions = new ProfilePageActions();
    private final MainPageActions mainPageActions = new MainPageActions();
    private final BookAppPageActions bookAppPageActions = new BookAppPageActions();

    @Test
    public void verifyLoginWithValidData() {
        mainPageActions.chooseCard(Cards.BOOK_STORE_APP);
        bookAppPageActions.chooseChapter(BookAppPage.Tabs.LOGIN);
        loginPageActions.fillLoginForm(USERNAME, PASSWORD);
        loginPageActions.clickLoginButton();
        String usernameAfterLogin = profilePageActions.getUsernameValue();
        Assertions.assertEquals(usernameAfterLogin, USERNAME);
    }
}
