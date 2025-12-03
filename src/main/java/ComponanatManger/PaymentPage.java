package ComponanatManger;

import Drivers.GUIDriver;
import Validations.Verification;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PaymentPage {
    private final GUIDriver driver;

    public PaymentPage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By emailField = By.id("email");
    private final By cardNumber = By.id("cardNumber");
    private final By cardExpiryDate = By.id("cardExpiry");
    private final By CVCFiled = By.id("cardCvc");
    private final By CardHolder = By.id("billingName");
    private final By submitBtn = By.className("SubmitButton-IconContainer");
    private final By emailErrorMsg=By.xpath("//input[@id='email']/following::span[@role=\"alert\"][1]");
    private final By cardErrorMsg=By.xpath("//input[@id='cardCvc']/following::span[@role=\"alert\"][1]");

@Step("enter email {email}")
    public PaymentPage enterEmail(String email){
        driver.element().type(emailField,email);
        return this;
    }
    @Step("enter card number {number}")
    public PaymentPage enterCardnumber(String number){
        driver.element().type(cardNumber,number);
        return this;
    }
    @Step("enter expiration date {date}")
    public PaymentPage enterExpDate(String date){
        driver.element().type(cardExpiryDate,date);
        return this;
    }
    @Step("enter CVC {CVC}")
    public PaymentPage enterCvc(String CVC){
        driver.element().type(CVCFiled,CVC);
        return this;
    }
    @Step("enter card holder name {name}")
    public PaymentPage enterCardHolder(String name){
        driver.element().type(CardHolder,name);
        return this;
    }
    @Step("submit payment")
public succefulPaymentPage submitPayment(){
        driver.element().click(submitBtn);
        return new succefulPaymentPage(driver);
}
@Step("validate rhe error message for email field")
    public PaymentPage validateEmailEMsg(String expectedMsg){
        String MSG= driver.element().getText(emailErrorMsg);
        new Verification().equals(MSG,expectedMsg,"message miss match");
        return this;
    }
    @Step("validate the error message for card field")
    public PaymentPage validateCardEMsg(String expectedMsg){
        String MSG= driver.element().getText(cardErrorMsg);
        new Verification().equals(MSG,expectedMsg,"message miss match");
        return this;
    }
}
