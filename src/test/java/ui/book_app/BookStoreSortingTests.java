package ui.book_app;

import actions.MainPageActions;
import actions.book_app.BookStorePageActions;
import com.codeborne.selenide.SelenideElement;
import components.Cards;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.BaseTest;

import java.util.List;

public class BookStoreSortingTests extends BaseTest {
    private final BookStorePageActions bookStorePageActions = new BookStorePageActions();
    private final MainPageActions mainPageActions = new MainPageActions();

    @Test
    public void sortingByTitle() {
        mainPageActions.chooseCard(Cards.BOOK_STORE_APP);
        List<String> titles = bookStorePageActions.getAllProductsTitles().stream().map(SelenideElement::getText).sorted().toList();
        bookStorePageActions.clickOnTitle();
        List<String> titlesAfterSorting = bookStorePageActions.getAllProductsTitles().stream().map(SelenideElement::getText).toList();
        Assertions.assertEquals(titles, titlesAfterSorting);
    }

    @Test
    public void sortingByAuthor() {
        mainPageActions.chooseCard(Cards.BOOK_STORE_APP);
        List<String> authors = bookStorePageActions.getAllProductsAuthors().stream().map(SelenideElement::text).sorted().toList();
        bookStorePageActions.clickOnAuthor();
        List<String> authorsAfterSorting = bookStorePageActions.getAllProductsAuthors().stream().map(SelenideElement::text).toList();
        Assertions.assertEquals(authors, authorsAfterSorting);
    }

}
