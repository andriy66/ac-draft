package actions.book_app;

import components.AlertComponent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import pages.book_app.ProductPage;

import static com.codeborne.selenide.Selenide.switchTo;

public class ProductPageActions implements AlertComponent {
    private ProductPage productPage = new ProductPage();

    public void addTheProductToCollection() {
        productPage.addToCollectionButton.click();
        confirmAlert();
    }
}
