package components;

import com.codeborne.selenide.SelenideElement;
import components.stateandcity.City;
import components.stateandcity.State;

public class StudentRegistrationForm implements BaseComponents {
    public final SelenideElement firstNameInputField = getElementById("firstName");
    public final SelenideElement lastNameInputField = getElementById("lastName");
    public final SelenideElement userEmailInputField = getElementById("userEmail");
    public final SelenideElement userNumberInputField = getElementById("userNumber");
    public final SelenideElement submitButton = getElementById("submit");
    public final SelenideElement dateOfBirthButton = getElementById("dateOfBirthInput");
    public final SelenideElement genderMaleRadioButton = getElementByText(Genders.MALE.getGender());
    public final SelenideElement genderFemaleRadioButton = getElementByText(Genders.FEMALE.getGender());
    public final SelenideElement genderOtherRadioButton = getElementByText(Genders.OTHER.getGender());
    public final SelenideElement subjectsInputField = getElementById("subjectsContainer");
    public final SelenideElement sportCheckboxField = getElementByText(Hobbies.SPORTS.getHobby());
    public final SelenideElement readingCheckboxField = getElementByText(Hobbies.READING.getHobby());
    public final SelenideElement musicCheckboxField = getElementByText(Hobbies.MUSIC.getHobby());
    public final SelenideElement uploadFileDragAndDrop = getElementById("uploadPicture");
    public final SelenideElement currentAddressInputField = getElementById("currentAddress");
    public final SelenideElement stateDropDown = getElementById("state");
    public final SelenideElement ncrDropDownOption = State.NCR.getStateElement();
    public final SelenideElement uttarPradeshDropDownOption = State.UTTAR_PRADESH.getStateElement();
    public final SelenideElement haryanaDropDownOption = State.HARYANA.getStateElement();
    public final SelenideElement rajasthanDropDownOption = State.RAJASTHAN.getStateElement();
    public final SelenideElement cityDropDown = getElementById("city");
//    public City city;
//    public State state;

    public enum Genders {
        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other");

        private String gender;
        Genders(String gender) {
            this.gender = gender;
        }

        public String getGender() {
            return gender;
        }
    }

    public enum Hobbies {
        SPORTS("Sports"),
        READING("Reading"),
        MUSIC("Music");

        private String hobbies;

        Hobbies(String hobbies) {
            this.hobbies = hobbies;
        }

        public String getHobby() {
            return hobbies;
        }
    }

}
