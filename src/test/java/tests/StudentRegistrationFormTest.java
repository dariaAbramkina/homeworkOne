package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import utils.TestUtils;
import java.io.File;

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
    private static final String STUDENT_NAME = "Student Name";
    private static final String STUDENT_EMAIL = "Student Email";
    private static final String GENDER = "Gender";
    private static final String MOBILE = "Mobile";
    private static final String DATE_OF_BIRTH = "Date of Birth";
    private static final String SUBJECTS = "Subjects";
    private static final String HOBBIES = "Hobbies";
    private static final String PICTURE = "Picture";
    private static final String ADDRESS = "Address";
    private static final String STATE_AND_CITY = "State and City";

    @BeforeEach
    public void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        File file = new File("src/test/resources/homer wfh.gif");
        String firstName = RandomStringUtils.randomAlphabetic(5);
        String lastName = RandomStringUtils.randomAlphabetic(7);
        String fullName = firstName + " " + lastName;
        String email = RandomStringUtils.randomAlphabetic(6) + RandomUtils.nextInt() + "@gmail.com";
        Long mobileNumber = TestUtils.getMobileNumber();
        String address = RandomStringUtils.randomAlphabetic(7);

        registrationPage
            .openPracticeForm()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .selectGender(FEMALE)
            .setMobile(mobileNumber)
            .setBirthDate(MONTH, YEAR, DAY)
            .setSubject(BIOLOGY)
            .selectHobby(READING)
            .uploadFile(file)
            .setAddress(address)
            .setState(STATE)
            .setCity(CITY)
            .scrollToSubmitButton()
            .pressSubmitButton();

        registrationPage
                .checkField(STUDENT_NAME, fullName)
                .checkField(STUDENT_EMAIL, email)
                .checkField(GENDER, FEMALE)
                .checkField(MOBILE, mobileNumber.toString())
                .checkField(DATE_OF_BIRTH,DAY + " " + JANUARY + "," + YEAR)
                .checkField(SUBJECTS, BIOLOGY)
                .checkField(HOBBIES, READING)
                .checkField(PICTURE, file.getName())
                .checkField(ADDRESS, address)
                .checkField(STATE_AND_CITY, STATE + " " + CITY);
    }
}
