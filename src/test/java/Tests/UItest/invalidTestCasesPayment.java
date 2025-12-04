package Tests.UItest;

import ComponanatManger.HeadBar;
import ComponanatManger.HomePage;
import ComponanatManger.PaymentPage;
import ComponanatManger.PropertyPage;
import Drivers.GUIDriver;
import Tests.BaseTest;
import Utils.DataReader.JsonReader;
import Utils.Logs.LogsManager;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Epic("GraduationProject - Web Automation Testing")
@Feature("invalid Test Cases in payment page")
@Story("payment")
@Severity(SeverityLevel.CRITICAL)
@Owner("Muhammed Sherif")
public class invalidTestCasesPayment extends BaseTest {
    GUIDriver driver;
    HeadBar HeadbarComp;
@Test
void userLogin(){ HeadbarComp.userLogin()
        .enterEmail(testData.getJsonData("user1.email"))
        .enterPassword(testData.getJsonData("user1.password"))
        .submitForm();

}
@Test(dependsOnMethods = "userLogin")
void selctProperty(){ HeadbarComp.navigateTOHomePage().filterItems(testData.getJsonData("filterItem1"))
        .viewNextImage(testData.getJsonData("filterProperty1"))
        .viewNextImage(testData.getJsonData("filterProperty1"))
        .viewNextImage(testData.getJsonData("filterProperty1"))
        .viewPreviousImage(testData.getJsonData("filterProperty1")).
        selectProperty(testData.getJsonData("filterProperty1"));
    }
    @Test(dependsOnMethods = {"userLogin","selctProperty"})
    void proceedToPaymentPage(){ new PropertyPage(driver)
            .ChoseDate("20")
            .choseCheckOutDate("21")
            .completeReservation();}
    @Test(dependsOnMethods = {"userLogin","selctProperty","proceedToPaymentPage"})
    void PaymentWithWrongCardNumber(){

        new PaymentPage(driver).enterEmail(testData.getJsonData("cardWithWrongNumber.email"))
                .enterCardnumber(testData.getJsonData("cardWithWrongNumber.number"))
                .enterExpDate(testData.getJsonData("cardWithWrongNumber.ExDate"))
                .enterCvc(testData.getJsonData("cardWithWrongNumber.CVV"))
                .enterCardHolder(testData.getJsonData("cardWithWrongNumber.holder"))
                .validateCardEMsg("Your card number is invalid.");
    }
    @Test(dependsOnMethods = {"userLogin","selctProperty","proceedToPaymentPage"})
    void PaymentWithWrongEmail(){

        new PaymentPage(driver).enterEmail(testData.getJsonData("cardWithWrongEmailFormat.email"))
                .enterCardnumber(testData.getJsonData("cardWithWrongEmailFormat.number"))
                .enterExpDate(testData.getJsonData("cardWithWrongEmailFormat.ExDate"))
                .enterCvc(testData.getJsonData("cardWithWrongEmailFormat.CVV"))
                .enterCardHolder(testData.getJsonData("cardWithWrongEmailFormat.holder"))
                .validateEmailEMsg("Your email is incomplete.");
    }
    @Test(dependsOnMethods = {"userLogin","selctProperty","proceedToPaymentPage"})
    void PaymentWithWrongCardExpDate(){

        new PaymentPage(driver).enterEmail(testData.getJsonData("cardWithWrongExpDate.email"))
                .enterCardnumber(testData.getJsonData("cardWithWrongExpDate.number"))
                .enterExpDate(testData.getJsonData("cardWithWrongExpDate.ExDate"))
                .enterCvc(testData.getJsonData("cardWithWrongExpDate.CVV"))
                .enterCardHolder(testData.getJsonData("cardWithWrongExpDate.holder"))
                .validateCardEMsg("Your card’s expiration year is in the past.");
    }
    @Test(dependsOnMethods = {"userLogin","selctProperty","proceedToPaymentPage"})
    void PaymentWithShortCVC(){

        new PaymentPage(driver).enterEmail(testData.getJsonData("cardWithShortCVC.email"))
                .enterCardnumber(testData.getJsonData("cardWithShortCVC.number"))
                .enterExpDate(testData.getJsonData("cardWithShortCVC.ExDate"))
                .enterCvc(testData.getJsonData("cardWithShortCVC.CVV"))
                .enterCardHolder(testData.getJsonData("cardWithShortCVC.holder"))
                .validateEmailEMsg("Your card’s security code is incomplete.");
    }







    @BeforeClass
    void beforeMethodConditions() {
        testData = new JsonReader("invalidData");
        driver = new GUIDriver();
        HeadbarComp = new HeadBar(driver);
        HeadbarComp.navigateTOHomePage();
        LogsManager.info("before test register test");
    }

    @AfterClass
    public void TearDown() {
        driver.quitDriver();
        LogsManager.info("after test register test");
    }
}
