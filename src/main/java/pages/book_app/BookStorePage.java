package pages.book_app;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class BookStorePage implements BasePage {
    public final ElementsCollection productsTitles = $$x("//div[@class='action-buttons']//span//a");
    private final ElementsCollection authorsAndPublishers = $$x("//div[@class='action-buttons']//parent::div/following-sibling::div");

    public final List<SelenideElement> productsAuthors() {
        authorsAndPublishers.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(1));
        List<SelenideElement> authors = new ArrayList<>();
        for (int i = 0; i < authorsAndPublishers.size(); i+=2) {
            authors.add(authorsAndPublishers.get(i));
        }
        return authors;
    }

    public final List<SelenideElement> productsPublishers() {
        authorsAndPublishers.shouldBe(CollectionCondition.sizeGreaterThanOrEqual(1));
        List<SelenideElement> publishers = new ArrayList<>();
        for (int i = 1; i < authorsAndPublishers.size() - 1; i+=2) {
            publishers.add(authorsAndPublishers.get(i));
        }
        return publishers;
    }

    public final SelenideElement titleButton = getElementByText("Title");
    public final SelenideElement authorButton = getElementByText("Author");
    public final SelenideElement publisherButton = getElementByText("Publisher");
}
