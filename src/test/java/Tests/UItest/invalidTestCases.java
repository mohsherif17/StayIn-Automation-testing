package Tests.UItest;

import ComponanatManger.HeadBar;
import ComponanatManger.PaymentPage;
import ComponanatManger.PropertyPage;
import Drivers.GUIDriver;
import Tests.BaseTest;
import Utils.DataReader.JsonReader;
import Utils.Logs.LogsManager;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Epic("GraduationProject - Web Automation Testing")
@Feature("invaldid Test Cases")
@Story("login")
@Severity(SeverityLevel.CRITICAL)
@Owner("Muhammed Sherif")
public class invalidTestCases extends BaseTest {
    GUIDriver driver;
    HeadBar HeadbarComp;
    @Test
    void LoginWithUnRegisteredEmailTc() {
        HeadbarComp.userLogin()
                .enterEmail(testData.getJsonData("userInvalidMail.email"))
                .enterPassword(testData.getJsonData("userInvalidMail.password"))
                .submitForm().validateErrorInLogin();
    }
    @Test
    void LoginWithWrongPassword() {
        HeadbarComp.userLogin()
                .enterEmail(testData.getJsonData("userInvalidPassword.email"))
                .enterPassword(testData.getJsonData("userInvalidPassword.password"))
                .submitForm().validateErrorInLogin();
    }

    @BeforeMethod
    void beforeMethodConditions() {
        testData = new JsonReader("invalidData");
        driver = new GUIDriver();
        HeadbarComp = new HeadBar(driver);
        HeadbarComp.navigateTOHomePage();
        LogsManager.info("before test register test");
    }

    @AfterMethod
    public void TearDown() {
        driver.quitDriver();
        LogsManager.info("after test register test");
    }
}
