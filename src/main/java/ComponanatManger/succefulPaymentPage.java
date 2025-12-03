package ComponanatManger;

import Drivers.GUIDriver;
import Validations.Validation;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class succefulPaymentPage {
    private final GUIDriver driver;

    public succefulPaymentPage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By successMSG= By.xpath("//h2[@class='text-center text-2xl font-bold text-gray-900 mb-2']");
    private final By totalPaid= By.xpath("//span[.='Total:']/following::span");
    private final By resrvationDate = By.xpath("//span[.='Dates:']/following::span[1]");
    private final By homePageBtn= By.xpath("//button[.=' Back to Home ']");

    @Step("return to home page")
    public HomePage returnToHomePage(){
        driver.element().click(homePageBtn);
        return new HomePage(driver);
    }
    @Step("validate success message")
    public succefulPaymentPage validateSuccessMSG(String expectedMSG) {
        String MSG = driver.element().getText(successMSG);
        new Validation().equals(MSG, expectedMSG, "success message miss match");
        return this;
    }
    @Step("validate total paid amount")
    public succefulPaymentPage validateTotalPaid(String expectedAmount) {
        String amount = driver.element().getText(totalPaid);
        new Validation().equals(amount, expectedAmount, "total paid amount miss match");
        return this;
    }

    @Step("validate reservation dates")
    public succefulPaymentPage validateReservationDates(String expectedDates) {
        String dates = driver.element().getText(resrvationDate);
        new Validation().equals(dates, expectedDates, "reservation dates miss match");
        return this;
    }


}
