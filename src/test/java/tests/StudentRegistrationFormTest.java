package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class StudentRegistrationFormTest {
    PracticeFormPage page;

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
        page.selectGender("Female");
        Random generator = new Random(System.currentTimeMillis());
        Long mobileNumber = Math.abs(generator.nextLong() % 10000000000L);
        page.inputMobile(mobileNumber);
        page.inputDateOfBirthClick();
        page.selectYear(1993);
        page.selectMonth(0);
        page.selectDay(18);
        page.inputSubjects("Biology");
        page.selectSubject("Biology");
        page.selectHobby("Reading");
        page.uploadFile(file);
        page.inputAddress(RandomStringUtils.randomAlphabetic(7));
        page.inputState("Haryana");
        page.inputCity("Panipat");
        page.scrollToSubmitButton();
        page.pressSubmitButton();
        assertThat(page.studentNameValueInSubmitForm().getText())
                .as("")
                .contains(fullName);


        page.selectYear(1993);

    }
}
