package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.TestUtils;
import java.io.File;
import static org.assertj.core.api.Assertions.assertThat;

public class StudentRegistrationFormTest {
    RegistrationFormPage registrationPage = new RegistrationFormPage();

    private static final String MALE = "Male";
    private static final String FEMALE = "Female";
    private static final String OTHER = "Other";
    private static final String  YEAR = "1993";
    private static final String  MONTH = "0";
    private static final String JANUARY = "January";
    private static final String  DAY = "18";
    private static final String BIOLOGY = "Biology";
    private static final String READING = "Reading";
    private static final String STATE = "Haryana";
    private static final String CITY = "Panipat";

    @BeforeEach
    public void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        File file = new File("src/test/java/resources/homer wfh.gif");
        String firstName = RandomStringUtils.randomAlphabetic(5);
        String lastName = RandomStringUtils.randomAlphabetic(7);
        String fullName = firstName + " " + lastName;
        String email = RandomStringUtils.randomAlphabetic(6) + RandomUtils.nextInt() + "@gmail.com";
        Long mobileNumber = TestUtils.getMobileNumber();
        String address = RandomStringUtils.randomAlphabetic(7);

        registrationPage
            .openPracticeForm()
            .printTextToFirstNameInput(firstName)
            .printTextToLastNameInput(lastName)
            .inputEmail(email)
            .selectGender(FEMALE)
            .inputMobile(mobileNumber)
            .inputDateOfBirthClick()
            .selectYear(YEAR)
            .selectMonth(MONTH)
            .selectDay(DAY)
            .inputSubjects(BIOLOGY)
            .selectSubject(BIOLOGY)
            .selectHobby(READING)
            .uploadFile(file)
            .inputAddress(address)
            .inputState(STATE)
            .inputCity(CITY)
            .scrollToSubmitButton()
            .pressSubmitButton();

        assertThat(registrationPage.studentNameValueInSubmitForm().getText())
                .as("Student name value is equals to %s", fullName)
                .contains(fullName);
        assertThat(registrationPage.studentEmailValueInSubmitForm().getText())
                .as("Student email value is equals to %s", email)
                .contains(email);
        assertThat(registrationPage.studentGenderValueInSubmitForm().getText())
                .as("Student gender value is equals to %s", FEMALE)
                .contains(FEMALE);
        assertThat(registrationPage.studentMobileValueInSubmitForm().getText())
                .as("Student mobileNumber value is equals to %s", mobileNumber)
                .contains(mobileNumber.toString());
        assertThat(registrationPage.studentDateOfBirthValueInSubmitForm().getText())
                .as("Student date of birth value is equals to %s %s,%s", DAY, JANUARY, YEAR)
                .contains(DAY + " " + JANUARY + "," + YEAR);
        assertThat(registrationPage.studentSubjectsValueInSubmitForm().getText())
                .as("Student subject value is equals to %s", BIOLOGY)
                .contains(BIOLOGY);
        assertThat(registrationPage.studentHobbiesValueInSubmitForm().getText())
                .as("Student hobby value is equals to %s", READING)
                .contains(READING);
        assertThat(registrationPage.attachmentNameValueInSubmitForm().getText())
                .as("Attachment name value is equals to %s", file.getName())
                .contains(file.getName());
        assertThat(registrationPage.studentAddressValueInSubmitForm().getText())
                .as("Student address value is equals to %s", address)
                .contains(address);
        assertThat(registrationPage.studentStateAndCityValueInSubmitForm().getText())
                .as("Student state and city value is equals to %s %s", STATE, CITY)
                .contains(STATE + " " + CITY);
    }
}
