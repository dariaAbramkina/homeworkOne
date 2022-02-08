package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {
    PracticeFormPage page;

    @BeforeEach
    public void setUp() {
        page = open("https://demoqa.com/automation-practice-form", PracticeFormPage.class);
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        page.printTextToFirstNameInput(RandomStringUtils.randomAlphabetic(5));
        page.printTextToLastNameInput(RandomStringUtils.randomAlphabetic(7));
        String email = RandomStringUtils.randomAlphabetic(6) + RandomUtils.nextInt() + "@gmail.com";
        page.inputEmail(email);
        page.selectGender("Female");
        Random generator = new Random(System.currentTimeMillis());
        Long mobileNumber = Math.abs(generator.nextLong() % 1000000000L);
        page.inputMobile(mobileNumber);
        page.inputDateOfBirthClick();
        page.selectYear(1993);
        page.selectMonth(0);
        page.selectDay(18);
        page.selectYear(1993);


    }
}
