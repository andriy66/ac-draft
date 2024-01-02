package ui;

import actions.MainPageActions;
import actions.book_app.BookAppPageActions;
import actions.book_app.LoginPageActions;
import base.LocalWebDriver;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import components.Cards;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.book_app.BookAppPage;
import pages.book_app.ProfilePage;

import static base.ConfigReader.PASSWORD;
import static base.ConfigReader.USERNAME;

public class BaseTest {
    private final LoginPageActions loginPageActions = new LoginPageActions();
    private final MainPageActions mainPageActions = new MainPageActions();
    private final BookAppPageActions bookAppPageActions = new BookAppPageActions();
    private final ProfilePage profilePage = new ProfilePage();

    @BeforeEach
    void setUp() {
        LocalWebDriver.createLocalDriver();
    }


    @AfterEach()
    void close() {
        Selenide.webdriver().driver().getWebDriver().close();
    }

    protected void loginWithDefaultUser() {
        mainPageActions.chooseCard(Cards.BOOK_STORE_APP);
        bookAppPageActions.chooseChapter(BookAppPage.Tabs.LOGIN);
        loginPageActions.fillLoginForm(USERNAME.getParameterValue(), PASSWORD.getParameterValue());
        loginPageActions.clickLoginButton();
        profilePage.userNameValue.shouldHave(Condition.text(USERNAME.getParameterValue()));
    }
}
