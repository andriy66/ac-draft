package ui;

import actions.FormsPageActions;
import actions.MainPageActions;
import actions.components.StudentRegistrationFormActions;
import base.LocalWebDriver;
import com.codeborne.selenide.Selenide;
import components.Cards;
import components.StudentRegistrationForm;
import components.SubmittingForm;
import components.stateandcity.State;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


public class FormsTests extends BaseTest {
    private MainPageActions mainPageActions = new MainPageActions();
    private FormsPageActions formsPageActions = new FormsPageActions();

    private StudentRegistrationFormActions studentRegistrationFormActions = new StudentRegistrationFormActions();
    private SubmittingForm submittingForm = new SubmittingForm();
    private String firstName = "FirstName";
    private String lastName = "LastName";
    private String email = "test@example.com";
    private String mobilePhone = "0999999999";
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM,yyyy", Locale.ENGLISH);
    private String localDate = date.format(formatter);

    @BeforeMethod
    void setUp() {

        LocalWebDriver.createLocalDriver();
    }

    @AfterTest()
    void close() {
        Selenide.webdriver().driver().getWebDriver().close();
    }
    @Test
    void canSubmitFormWithValidData () {
        mainPageActions.chooseCard(Cards.FORMS);
        formsPageActions.clickOnPracticeFormButton();
        studentRegistrationFormActions.fillInRequiredData(firstName, lastName, email, mobilePhone);
        studentRegistrationFormActions.chooseStateAndCity(State.NCR, State.NCR.getStateCities().get(2));
        studentRegistrationFormActions.chooseHobbies(List.of(StudentRegistrationForm.Hobbies.MUSIC, StudentRegistrationForm.Hobbies.READING, StudentRegistrationForm.Hobbies.SPORTS));
        studentRegistrationFormActions.chooseGender(StudentRegistrationForm.Genders.MALE);
        studentRegistrationFormActions.clickSubmitButton();

        //Set all keys from the form
        String studentFullName = submittingForm.getValueOfLabel("Student Name");
        String studentEmail = submittingForm.getValueOfLabel("Student Email");
        String gender = submittingForm.getValueOfLabel("Gender");
        String mobile = submittingForm.getValueOfLabel("Mobile");
        String dateOfBirth = submittingForm.getValueOfLabel("Date of Birth");
        String subjects = submittingForm.getValueOfLabel("Subjects");
        String hobbies = submittingForm.getValueOfLabel("Hobbies");
        String picture = submittingForm.getValueOfLabel("Picture");
        String address = submittingForm.getValueOfLabel("Address");
        String stateAndCity = submittingForm.getValueOfLabel("State and City");

        Assert.assertEquals(String.format("%s %s", firstName, lastName), studentFullName);
        Assert.assertEquals(studentEmail, email);
        Assert.assertEquals(gender, "Male");
        Assert.assertEquals(mobile, mobilePhone);
        Assert.assertEquals(dateOfBirth, localDate);
        Assert.assertEquals(subjects, "");
        Assert.assertEquals(hobbies, "Music, Reading, Sports");
        Assert.assertEquals(picture, "");
        Assert.assertEquals(address, "");
        Assert.assertEquals(stateAndCity,"NCR Noida");
    }
}
