package actions.book_app;

import actions.components.DeleteProductAlertActions;
import com.codeborne.selenide.SelenideElement;
import components.AlertComponent;
import components.book_app.DeleteProductAlert;
import pages.book_app.ProfilePage;

import java.util.List;
import java.util.stream.Collectors;

public class ProfilePageActions implements AlertComponent {
    private ProfilePage profilePage = new ProfilePage();
    private final DeleteProductAlertActions deleteProductAlert = new DeleteProductAlertActions();
    public String getUsernameValue() {
        return profilePage.userNameValue.text();
    }

    public void clickOnGoToStoreButton() {
        profilePage.goToBookStoreButton.click();
    }

    public List<String> getTitlesOfProducts() {
       return profilePage.products.stream().map(SelenideElement::text).collect(Collectors.toList());
    }

    public void deleteAllProductsFromCollections() {
        List<SelenideElement> products = profilePage.productsDeleteButtons;
        for(SelenideElement product : products) {
            product.click();
            deleteProductAlert.clickOk();
            confirmAlert();
        }
    }
}
