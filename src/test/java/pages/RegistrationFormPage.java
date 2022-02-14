package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    CalendarComponent calendar = new CalendarComponent();

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

    private SelenideElement subjects() {
        return practiceForm().$x(".//*[@id='subjectsInput']");
    }

    private SelenideElement subjectOptions() {
        return practiceForm().$x(".//*[contains(@class, 'subjects-auto-complete__menu-list')]");
    }

    private SelenideElement chooseFileButton() {
        return practiceForm().$x(".//*[@id='uploadPicture']");
    }

    private SelenideElement addressInput() {
        return practiceForm().$x(".//*[@id='currentAddress']");
    }

    private SelenideElement stateInput() {
        return practiceForm().$x(".//*[@id='react-select-3-input']");
    }

    private SelenideElement cityInput() {
        return practiceForm().$x(".//*[@id='react-select-4-input']");
    }

    private SelenideElement submitButton() { return practiceForm().$x(".//*[@id='submit']"); }

    private SelenideElement table() {
        return $x("//*[@class='table-responsive']");
    }

    public RegistrationFormPage openPracticeForm(){
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setBirthDate(String month, String year, String day) {
        dateOfBirth().click();
        calendar.setDate(month, year, day);
        return this;
    }

    public RegistrationFormPage selectGender(String gender) {
        practiceForm().$x(".//*[@class='custom-control-label' and contains(.,'"+ gender +"')]").click();
        return this;
    }

    public RegistrationFormPage selectHobby(String hobby) {
        practiceForm().$x(".//*[@class='custom-control-label' and contains(.,'"+ hobby +"')]").click();
        return this;
    }

    public RegistrationFormPage setFirstName(String text) {
        firstNameInput().setValue(text);
        return this;
    }

    public RegistrationFormPage setLastName(String text) {
        lastNameInput().setValue(text);
        return this;
    }

    public RegistrationFormPage setEmail(String text) {
        email().setValue(text);
        return this;
    }

    public RegistrationFormPage setMobile(Long number) {
        mobile().setValue(number.toString());
        return this;
    }

    public RegistrationFormPage setSubject(String subject){
        subjects().setValue(subject);
        subjectOptions().$x(".//*[contains(., '"+ subject +"')]").click();
        return this;
    }

    public RegistrationFormPage uploadFile(File file){
        chooseFileButton().uploadFile(file);
        return this;
    }

    public RegistrationFormPage setAddress(String text) {
        addressInput().setValue(text);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        stateInput().setValue(state);
        stateInput().pressEnter();
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        cityInput().setValue(city);
        cityInput().pressEnter();
        return this;
    }

    public RegistrationFormPage scrollToSubmitButton() {
        submitButton().scrollTo();
        return this;
    }

    public RegistrationFormPage pressSubmitButton() {
        submitButton().click();
        return this;
    }

    public RegistrationFormPage checkField(String fieldName, String value) {
        table().$x(".//*[contains(., '"+ fieldName +"')]").parent().shouldHave(Condition.text(value));
        return this;
    }
}
