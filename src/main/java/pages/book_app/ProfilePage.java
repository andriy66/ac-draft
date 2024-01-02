package pages.book_app;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$$x;

public class ProfilePage implements BasePage {
    public final SelenideElement userNameValue = getElementById("userName-value");
    public final SelenideElement goToBookStoreButton = getElementById("gotoStore");

    public final ElementsCollection products = $$x("//div[@class='action-buttons']//span//a");
    public final ElementsCollection productsDeleteButtons = $$x("//span[@title='Delete']");
}
