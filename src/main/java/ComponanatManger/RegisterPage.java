package ComponanatManger;

import Drivers.GUIDriver;
import Utils.DataReader.PropertyReader;
import Validations.Verification;
import io.qameta.allure.Step;
import org.apache.poi.xssf.usermodel.TextHorizontalOverflow;
import org.openqa.selenium.By;

public class RegisterPage {
    private final GUIDriver driver;
    private final String RegEndPoint="/auth/register";
    public RegisterPage(GUIDriver driver){
        this.driver=driver;
    }

    private final By UserName=By.id("floating_username");
    private final By EmailField=By.id("floating_email");
    private final By PasswordField=By.id("floating_password");
    private final By ConfirmPasswordField=By.id("floating_confirm_password");
    private final By FirstNameField=By.id("floating_first_name");
    private final By LastNameField=By.id("floating_last_name");
    private final By PhoneField=By.id("floating_phone");
    private final By NationalIdField=By.id("floating_company");
    private final By AddressField=By.id("floating_address");
    private final By DateField=By.id("floating_date");
    private final By TermsCB=By.id("terms");
    private final By SubmitBtn=By.tagName("button");
    private final By errorMsg=By.xpath("//div[@class='mb-4 p-4 bg-red-100 border border-red-400 text-red-700 rounded']");



@Step("navigate to register page")
    public RegisterPage navigateToRegisterpage(){
        driver.browser().navigateToUrl(PropertyReader.getProperty("baseUrlWeb")+RegEndPoint);
        return this;
    }
@Step("fill registertion data ")
    public RegisterPage fillRegisterForm(String userName,String email,String Password,
                                         String ConfirmPassword,String FName,String LName,
                                         String pNumber,String NatID,String address,
                                         String bDate){
        driver.element().type(UserName,userName);
        driver.element().type(EmailField,email);
        driver.element().type(PasswordField,Password);
        driver.element().type(ConfirmPasswordField,ConfirmPassword);
        driver.element().type(FirstNameField,FName);
        driver.element().type(LastNameField,LName);
        driver.element().type(PhoneField,pNumber);
        driver.element().type(NationalIdField,NatID);
        driver.element().type(AddressField,address);
        driver.element().type(DateField,bDate);
        driver.element().click(TermsCB);
        return this;
    }
    @Step("submit the form")
    public RegisterPage submitRegisterForm(){
        driver.element().click(SubmitBtn);
        return this;
    }
    @Step("validate error message")
    public RegisterPage validateErrorMessage(String expectedMSG){
        String actualMSG=driver.element().getText(errorMsg);
        new Verification().equals(actualMSG,expectedMSG,"error Message Miss Match");
        return this;
    }

}
