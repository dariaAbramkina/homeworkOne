package tests;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

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

    private SelenideElement submitButton() {
        return practiceForm().$x(".//*[@id='submit']");
    }

    private SelenideElement table() {
        return $x("//*[@class='table-responsive']");
    }

    public List<SelenideElement> tableElements() {
        return table().$$x(".//tbody/tr");
    }

    public SelenideElement studentNameValueInSubmitForm() {
        return tableElements().get(0).$x(".//td[2]");
    }

    public SelenideElement studentEmailValueInSubmitForm() {
        return tableElements().get(1).$x(".//td[2]");
    }

    public SelenideElement studentGenderValueInSubmitForm() {
        return tableElements().get(2).$x(".//td[2]");
    }

    public SelenideElement studentMobileValueInSubmitForm() {
        return tableElements().get(3).$x(".//td[2]");
    }

    public SelenideElement studentDateOfBirthValueInSubmitForm() {
        return tableElements().get(4).$x(".//td[2]");
    }

    public SelenideElement studentSubjectsValueInSubmitForm() {
        return tableElements().get(5).$x(".//td[2]");
    }

    public SelenideElement studentHobbiesValueInSubmitForm() {
        return tableElements().get(6).$x(".//td[2]");
    }

    public SelenideElement attachmentNameValueInSubmitForm() {
        return tableElements().get(7).$x(".//td[2]");
    }

    public SelenideElement studentAddressValueInSubmitForm() {
        return tableElements().get(8).$x(".//td[2]");
    }

    public SelenideElement studentStateAndCityValueInSubmitForm() {
        return tableElements().get(9).$x(".//td[2]");
    }

    public void selectMonth(String month) {
        monthsList().selectOptionByValue(month);
    }

    public void selectYear(String year) {
        yearsList().selectOptionByValue(year);
    }

    public void selectDay(String day) {
        daysList().$x(".//*[contains(@class, 'react-datepicker__day') and contains(., '"+ day +"') and not(contains(@class, 'outside-month'))]").click();
    }

    public void selectGender(String gender) {
        practiceForm().$x(".//*[@class='custom-control-label' and contains(.,'"+ gender +"')]").click();
    }

    public void selectHobby(String hobby) {
        practiceForm().$x(".//*[@class='custom-control-label' and contains(.,'"+ hobby +"')]").click();
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
        mobile().setValue(number.toString());
    }
    public void inputDateOfBirthClick() {
        dateOfBirth().click();
    }

    public void inputSubjects(String text) {
        subjects().sendKeys(text);
    }

    public void selectSubject(String subject){
        subjectOptions().$x(".//*[contains(., '"+ subject +"')]").click();
    }

    public void uploadFile(File file){
        chooseFileButton().uploadFile(file);
    }

    public void inputAddress(String text) {
        addressInput().setValue(text);
    }

    public void inputState(String state) {
        stateInput().sendKeys(state);
        stateInput().pressEnter();
    }

    public void inputCity(String city) {
        cityInput().sendKeys(city);
        cityInput().pressEnter();
    }

    public  void scrollToSubmitButton() {
        submitButton().scrollTo();
    }

    public void pressSubmitButton() {
        submitButton().click();
    }
}
