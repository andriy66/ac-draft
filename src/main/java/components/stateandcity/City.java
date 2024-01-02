package components.stateandcity;

import com.codeborne.selenide.SelenideElement;
import components.BaseComponents;

public enum City implements BaseComponents {
    //NCR
    DELHI("Delhi"),
    GURGAON("Gurgaon"),
    NOIDA("Noida"),

    //UTTAR_PRADESH
    AGRA("Agra"),
    MERRUT("Merrut"),
    LUCKNOW("Lucknow"),

    //Harya
    KARNAL("Karnal"),
    PANIPAT("Panipat"),

    //Raja
    JAIPUR("Jaipur"),
    JAISELMER("Jaiselmer");

    private String city;
    private SelenideElement cityElement;

    City(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public SelenideElement getCityElement() {
        cityElement = getElementByText(city);
        return cityElement;
    }
}
