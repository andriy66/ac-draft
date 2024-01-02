package actions.components;

import com.codeborne.selenide.Condition;
import components.book_app.DeleteProductAlert;

public class DeleteProductAlertActions {
    private DeleteProductAlert deleteProductAlert = new DeleteProductAlert();
    public void clickOk() {
        deleteProductAlert.okButton.shouldBe(Condition.visible).click();
    }
}
