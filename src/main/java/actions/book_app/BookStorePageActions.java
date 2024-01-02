package actions.book_app;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.book_app.BookStorePage;

import java.util.List;
import java.util.stream.Collectors;

public class BookStorePageActions {
    private BookStorePage bookStorePage = new BookStorePage();
    public String openProductInfo(int index) {
        SelenideElement product = bookStorePage.productsTitles.get(index);
        String productInfo = product.text();
        product.click();
        return productInfo;
    }

    public void openProductInfo(String productName) {
        bookStorePage.productsTitles.stream()
                .filter(product -> product.text().equals(productName))
                .collect(Collectors.toList()).stream()
                .forEach(product -> product.click());
    }

    public ElementsCollection getAllProductsTitles() {
        return bookStorePage.productsTitles.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(1));
    }

    public List<SelenideElement> getAllProductsAuthors() {
        return bookStorePage.productsAuthors();
    }

    public List<SelenideElement> getAllProductsPublishers() {
        return bookStorePage.productsPublishers();
    }

    public void clickOnTitle() {
        bookStorePage.titleButton.click();
    }
    public void clickOnAuthor() {
        bookStorePage.authorButton.click();
    }

    public void clickOnPublisher() {
        bookStorePage.publisherButton.click();
    }
}
