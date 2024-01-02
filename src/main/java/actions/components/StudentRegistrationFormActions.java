package actions.components;

import com.codeborne.selenide.Condition;
import components.StudentRegistrationForm;
import components.SubmittingForm;
import components.stateandcity.City;
import components.stateandcity.State;

import java.util.List;

public class StudentRegistrationFormActions {
    private StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm();
    public void fillInRequiredData(String firstName, String lastName, String email, String mobilePhone) {
        studentRegistrationForm.userEmailInputField.sendKeys(email);
        studentRegistrationForm.firstNameInputField.sendKeys(firstName);
        studentRegistrationForm.lastNameInputField.sendKeys(lastName);
        studentRegistrationForm.userNumberInputField.sendKeys(mobilePhone);
        //another required fields


    }

    public void clickSubmitButton() {
        studentRegistrationForm.submitButton.click();
    }

    public void chooseGender(StudentRegistrationForm.Genders genders) {
        switch (genders) {
            case MALE -> studentRegistrationForm.genderMaleRadioButton.click();
            case FEMALE -> studentRegistrationForm.genderFemaleRadioButton.click();
            case OTHER -> studentRegistrationForm.genderOtherRadioButton.click();
        }
    }

    public void inputDataInSubjectField(String data) {
        studentRegistrationForm.subjectsInputField.sendKeys(data);
    }

    public void chooseHobbies(List<StudentRegistrationForm.Hobbies> hobbiesList) {
        for(StudentRegistrationForm.Hobbies hobby : hobbiesList) {
            switch (hobby) {
                case READING -> studentRegistrationForm.readingCheckboxField.click();
                case MUSIC -> studentRegistrationForm.musicCheckboxField.click();
                case SPORTS -> studentRegistrationForm.sportCheckboxField.click();
            }
        }
    }

    public void chooseStateAndCity(State state, City city) {
        studentRegistrationForm.stateDropDown.shouldBe(Condition.visible).click();
        state.getStateElement().click();
        studentRegistrationForm.cityDropDown.click();
        city.getCityElement().click();
    }


}
