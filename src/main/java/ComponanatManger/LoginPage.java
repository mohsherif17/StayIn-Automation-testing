package ComponanatManger;

import Drivers.GUIDriver;
import Utils.DataReader.PropertyReader;
import Validations.Verification;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    private final GUIDriver driver;
private final String LoginPageEndPoint="/auth/login";
    public LoginPage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By emailAddress = By.id("email");
    private final By password = By.id("password");
    private final By submitBtn = By.tagName("button");
    private final By errorMSg = By.xpath("//div[@class='p-4 text-sm text-red-700 bg-red-100 rounded-md']");
    @Step("navigate to login page")
    public LoginPage navigateToLoginPage(){
        driver.browser().navigateToUrl(PropertyReader.getProperty("baseUrlWeb")+LoginPageEndPoint);
        return this;
    }
    @Step("insert user email:{Email}")
    public LoginPage enterEmail(String Email) {
        driver.element().type(emailAddress, Email);
        return this;
    }
    @Step("insert user password")
    public LoginPage enterPassword(String Password) {
        driver.element().type(password, Password);
        return this;
    }
    @Step("submit login form")
    public LoginPage submitForm() {
        driver.element().click(submitBtn);
        return this;
    }
    @Step("validate error message is displayed ")
    public LoginPage validateErrorInLogin() {
        String msg = driver.element().getText(errorMSg);
        new Verification().equals(msg, "Invalid credentials. Please try again.", "cant find element");
        return this;
    }
}