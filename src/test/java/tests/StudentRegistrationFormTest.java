package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class StudentRegistrationFormTest {
    PracticeFormPage page;

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
        Configuration.browserSize = "1920x1080";
        page = open("https://demoqa.com/automation-practice-form", PracticeFormPage.class);
    }

    @Test
    void successFillTest() {
        File file = new File("src/test/java/resources/homer wfh.gif");
        String firstName = RandomStringUtils.randomAlphabetic(5);
        String lastName = RandomStringUtils.randomAlphabetic(7);
        String fullName = firstName + " " + lastName;
        page.printTextToFirstNameInput(firstName);
        page.printTextToLastNameInput(lastName);
        String email = RandomStringUtils.randomAlphabetic(6) + RandomUtils.nextInt() + "@gmail.com";
        page.inputEmail(email);
        page.selectGender(FEMALE);
        Long mobileNumber = TestUtils.getMobileNumber();
        page.inputMobile(mobileNumber);
        page.inputDateOfBirthClick();
        page.selectYear(YEAR);
        page.selectMonth(MONTH);
        page.selectDay(DAY);
        page.inputSubjects(BIOLOGY);
        page.selectSubject(BIOLOGY);
        page.selectHobby(READING);
        page.uploadFile(file);
        String address = RandomStringUtils.randomAlphabetic(7);
        page.inputAddress(address);
        page.inputState(STATE);
        page.inputCity(CITY);
        page.scrollToSubmitButton();
        page.pressSubmitButton();
        assertThat(page.studentNameValueInSubmitForm().getText())
                .as("Student name value is equals to %s", fullName)
                .contains(fullName);
        assertThat(page.studentEmailValueInSubmitForm().getText())
                .as("Student email value is equals to %s", email)
                .contains(email);
        assertThat(page.studentGenderValueInSubmitForm().getText())
                .as("Student gender value is equals to %s", FEMALE)
                .contains(FEMALE);
        assertThat(page.studentMobileValueInSubmitForm().getText())
                .as("Student mobileNumber value is equals to %s", mobileNumber)
                .contains(mobileNumber.toString());
        assertThat(page.studentDateOfBirthValueInSubmitForm().getText())
                .as("Student date of birth value is equals to %s %s,%s", DAY, JANUARY, YEAR)
                .contains(DAY + " " + JANUARY + "," + YEAR);
        assertThat(page.studentSubjectsValueInSubmitForm().getText())
                .as("Student subject value is equals to %s", BIOLOGY)
                .contains(BIOLOGY);
        assertThat(page.studentHobbiesValueInSubmitForm().getText())
                .as("Student hobby value is equals to %s", READING)
                .contains(READING);
        assertThat(page.attachmentNameValueInSubmitForm().getText())
                .as("Attachment name value is equals to %s", file.getName())
                .contains(file.getName());
        assertThat(page.studentAddressValueInSubmitForm().getText())
                .as("Student address value is equals to %s", address)
                .contains(address);
        assertThat(page.studentStateAndCityValueInSubmitForm().getText())
                .as("Student state and city value is equals to %s %s", STATE, CITY)
                .contains(STATE + " " + CITY);
    }
}
