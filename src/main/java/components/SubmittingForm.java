package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SubmittingForm implements BaseComponents {
    public String getValueOfLabel(String labelName) {
        SelenideElement element = $x(String.format("//td[text()='%s']/following-sibling::td", labelName)).shouldBe(Condition.visible);
        return element.text();
    }
}
