package ui;

import actions.MainPageActions;
import actions.book_app.BookAppPageActions;
import actions.book_app.LoginPageActions;
import com.codeborne.selenide.Condition;
import components.Cards;
import pages.book_app.BookAppPage;
import pages.book_app.ProfilePage;

import static utils.ConfigReader.USERNAME;
import static utils.ConfigReader.PASSWORD;

public class BaseTest {
    private final LoginPageActions loginPageActions = new LoginPageActions();
    private final MainPageActions mainPageActions = new MainPageActions();
    private final BookAppPageActions bookAppPageActions = new BookAppPageActions();
    private final ProfilePage profilePage = new ProfilePage();

    protected void loginWithDefaultUser() {
        mainPageActions.chooseCard(Cards.BOOK_STORE_APP);
        bookAppPageActions.chooseChapter(BookAppPage.Tabs.LOGIN);
        loginPageActions.fillLoginForm(USERNAME.getParameterValue(), PASSWORD.getParameterValue());
        loginPageActions.clickLoginButton();
        profilePage.userNameValue.shouldHave(Condition.text(USERNAME.getParameterValue()));
    }
}
