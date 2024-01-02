package ui.book_app;

import actions.book_app.*;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.book_app.BookAppPage;
import pages.book_app.ProfilePage;
import ui.BaseTest;

import static base.ConfigReader.USERNAME;

public class BookStoreTests extends BaseTest {
    private final BookAppPageActions bookAppPageActions = new BookAppPageActions();
    private final ProfilePageActions profilePageActions = new ProfilePageActions();
    private final BookStorePageActions bookStorePageActions = new BookStorePageActions();
    private final ProductPageActions productPageActions = new ProductPageActions();
    private final ProfilePage profilePage = new ProfilePage();

    @Test
    public void verifyUserCanAddOneProductToCollection() {
        loginWithDefaultUser();
        int indexOfProduct = 0;
        bookAppPageActions.chooseChapter(BookAppPage.Tabs.PROFILE);
        profilePageActions.clickOnGoToStoreButton();
        String productTitle = bookStorePageActions.openProductInfo(indexOfProduct);
        productPageActions.addTheProductToCollection();
        bookAppPageActions.chooseChapter(BookAppPage.Tabs.PROFILE);
        profilePage.userNameValue.shouldHave(Condition.text(USERNAME.getParameterValue()));
        boolean isInProfile = profilePageActions.getTitlesOfProducts().contains(productTitle);
        Assertions.assertTrue(isInProfile);
        profilePageActions.deleteAllProductsFromCollections();
        Assertions.assertEquals(profilePageActions.getTitlesOfProducts().size(),0);
    }
}
