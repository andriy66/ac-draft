package components;

import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.switchTo;

public interface AlertComponent {
    default void confirmAlert() {
        switchTo().alert().accept();
    }

    default String getAlertMessage() {
        Alert alert = switchTo().alert();
        return alert.getText();
    }
}
