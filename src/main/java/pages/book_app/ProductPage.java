package pages.book_app;

import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

public class ProductPage implements BasePage {
    public final SelenideElement addToCollectionButton = getElementByText("Add To Your Collection");
}
