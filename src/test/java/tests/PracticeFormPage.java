package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Month;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private SelenideElement practiceForm() {
        return $x("//*[@class='practice-form-wrapper']");
    }

    private SelenideElement firstNameInput() {
        return practiceForm().$x(".//*[@id='firstName']");
    }

    private SelenideElement lastNameInput() {
        return practiceForm().$x(".//*[@id='lastName']");
    }

    private SelenideElement email() {
        return practiceForm().$x(".//*[@id='userEmail']");
    }

    private SelenideElement mobile() {
        return practiceForm().$x(".//*[@id='userNumber']");
    }

    private SelenideElement dateOfBirth() {
        return practiceForm().$x(".//*[@id='dateOfBirthInput']");
    }

    private SelenideElement monthsList() {
        return practiceForm().$x(".//*[@class='react-datepicker__month-select']");
    }

    private SelenideElement yearsList() {
        return practiceForm().$x(".//*[@class='react-datepicker__year-select']");
    }

    private SelenideElement daysList() {
        return practiceForm().$x(".//*[@class='react-datepicker__month']");
    }

    public void selectMonth(Integer month) {
        monthsList().selectOptionByValue(month.toString());
    }

    public void selectYear(Integer year) {
        yearsList().selectOptionByValue(year.toString());
    }

    public void selectDay(Integer day) {
        daysList().$x(".//*[contains(@class, 'react-datepicker__day') and contains(., '"+ day +"') and not(contains(@class, 'outside-month'))]").click();
    }

    public void selectGender(String gender) {
        practiceForm().$x(".//*[@class='custom-control-label' and contains(.,'"+ gender +"')]").click();
    }

    public void printTextToFirstNameInput(String text) {
        firstNameInput().setValue(text);
    }

    public void printTextToLastNameInput(String text) {
        lastNameInput().setValue(text);
    }

    public void inputEmail(String text) {
        email().setValue(text);
    }

    public void inputMobile(Long number) {
        mobile().setValue("8" + number);
    }
    public void inputDateOfBirthClick() {
        dateOfBirth().click();
    }



    public void checkRegistrationFormOutput(String firstName, String lastName) {
        //firstNameInput().setValue(text);
    }

}
