package actions;

import components.Cards;
import pages.MainPage;

public class MainPageActions {
    private MainPage mainPage = new MainPage();
    public void chooseCard(Cards cards) {
        switch (cards) {
            case FORMS -> mainPage.formsCard.click();
            case WIDGETS -> mainPage.widgetsCard.click();
            case ELEMENTS -> mainPage.elementsCard.click();
            case ALERTS_FRAME_WINDOWS -> mainPage.alertsFrameWindowsCard.click();
            case INTERACTIONS -> mainPage.interactionsCard.click();
            case BOOK_STORE_APP -> mainPage.bookStoreApplicationCard.click();
        }
    }
}
