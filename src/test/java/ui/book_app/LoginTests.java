package ui.book_app;

import actions.MainPageActions;
import actions.book_app.BookAppPageActions;
import actions.book_app.LoginPageActions;
import actions.book_app.ProfilePageActions;
import base.ConfigReader;
import base.LocalWebDriver;
import com.codeborne.selenide.Selenide;
import components.Cards;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.book_app.BookAppPage;
import ui.BaseTest;

public class LoginTests extends BaseTest {
    private final String PASSWORD = ConfigReader.PASSWORD.getParameterValue();
    private final String USERNAME = ConfigReader.USERNAME.getParameterValue();
    private final LoginPageActions loginPageActions = new LoginPageActions();
    private final ProfilePageActions profilePageActions = new ProfilePageActions();
    private final MainPageActions mainPageActions = new MainPageActions();
    private final BookAppPageActions bookAppPageActions = new BookAppPageActions();
    @BeforeMethod
    void setUp() {

        LocalWebDriver.createLocalDriver();
    }

    @AfterTest()
    void close() {
        Selenide.webdriver().driver().getWebDriver().close();
    }
    @Test
    public void verifyLoginWithValidData() {
        mainPageActions.chooseCard(Cards.BOOK_STORE_APP);
        bookAppPageActions.chooseChapter(BookAppPage.Tabs.LOGIN);
        loginPageActions.fillLoginForm(USERNAME, PASSWORD);
        loginPageActions.clickLoginButton();
        String usernameAfterLogin = profilePageActions.getUsernameValue();
        Assert.assertEquals(usernameAfterLogin, USERNAME);
    }
}
