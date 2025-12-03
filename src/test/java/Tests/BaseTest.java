package Tests;


import ComponanatManger.HeadBar;
import ComponanatManger.HomePage;
import ComponanatManger.LoginPage;
import Drivers.GUIDriver;
import Drivers.WebDriverProvider;
import Utils.AllureUtils;
import Utils.DataReader.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTest implements WebDriverProvider {

    protected GUIDriver driver;
    public JsonReader testData;




    @Override
    public WebDriver getWebDriver() {
        return driver.get();
    }
}
