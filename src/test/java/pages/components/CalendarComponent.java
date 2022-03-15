package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    private SelenideElement monthsList() {
        return $x(".//*[@class='react-datepicker__month-select']");
    }
    private SelenideElement yearsList() {
        return $x(".//*[@class='react-datepicker__year-select']");
    }
    private SelenideElement daysList() {
        return $x(".//*[@class='react-datepicker__month']");
    }

    public void setDate(String month, String year, String day) {
        monthsList().selectOptionByValue(month);
        yearsList().selectOptionByValue(year);
        daysList().$x(".//*[contains(@class, 'react-datepicker__day') and contains(., '"+ day +"') " +
                "and not(contains(@class, 'outside-month'))]").click();
    }
}
