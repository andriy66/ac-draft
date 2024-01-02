package pages.book_app;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.BasePage;

public class BookAppPage implements BasePage {
    public SelenideElement chooseTab(Tabs data) {return getElementByText(data.getData()); }

    public enum Tabs {
        LOGIN("Login"), BOOK_STORE("Book Store"), PROFILE("Profile"), BOOK_STORE_API("Book Store API");
        private String data;

        Tabs(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }
}
