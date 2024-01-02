package pages;

import components.Cards;
import com.codeborne.selenide.SelenideElement;

public class MainPage implements BasePage {
    public final SelenideElement formsCard = getElementByText(Cards.FORMS.getName());
    public final SelenideElement elementsCard = getElementByText(Cards.ELEMENTS.getName());
    public final SelenideElement alertsFrameWindowsCard = getElementByText(Cards.ALERTS_FRAME_WINDOWS.getName());
    public final SelenideElement widgetsCard = getElementByText(Cards.WIDGETS.getName());
    public final SelenideElement interactionsCard = getElementByText(Cards.INTERACTIONS.getName());
    public final SelenideElement bookStoreApplicationCard = getElementByText(Cards.BOOK_STORE_APP.getName());
}
