package ui.book_app;

import actions.MainPageActions;
import actions.book_app.BookStorePageActions;
import base.LocalWebDriver;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import components.Cards;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.BaseTest;

import java.util.List;

public class BookStoreSortingTests extends BaseTest {
    private final BookStorePageActions bookStorePageActions = new BookStorePageActions();
    private final MainPageActions mainPageActions = new MainPageActions();
    @BeforeTest
    void setUp() {
        LocalWebDriver.createLocalDriver();
    }
    @Test
    public void sortingByTitle() {
        mainPageActions.chooseCard(Cards.BOOK_STORE_APP);
        List<String> titles = bookStorePageActions.getAllProductsTitles().stream().map(SelenideElement::getText).sorted().toList();
        bookStorePageActions.clickOnTitle();
        List<String> titlesAfterSorting = bookStorePageActions.getAllProductsTitles().stream().map(SelenideElement::getText).toList();
        Assert.assertEquals(titles, titlesAfterSorting);
    }

    @Test
    public void sortingByAuthor() {
        mainPageActions.chooseCard(Cards.BOOK_STORE_APP);
        List<String> authors = bookStorePageActions.getAllProductsAuthors().stream().map(SelenideElement::text).sorted().toList();
        bookStorePageActions.clickOnAuthor();
        List<String> authorsAfterSorting = bookStorePageActions.getAllProductsAuthors().stream().map(SelenideElement::text).toList();
        Assert.assertEquals(authors, authorsAfterSorting);
    }
    @AfterTest()
    void close() {
        Selenide.webdriver().driver().getWebDriver().close();
    }

}
