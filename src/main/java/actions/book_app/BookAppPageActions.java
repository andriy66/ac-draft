package actions.book_app;

import com.codeborne.selenide.Condition;
import pages.book_app.BookAppPage;

public class BookAppPageActions {
    private BookAppPage bookAppPage = new BookAppPage();

    public void chooseChapter(BookAppPage.Tabs tabs) {
        bookAppPage.chooseTab(tabs).shouldBe(Condition.visible).click();
    }
}
