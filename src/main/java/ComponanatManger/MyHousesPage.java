package ComponanatManger;

import Drivers.GUIDriver;
import Utils.DataReader.PropertyReader;
import Validations.Verification;
import io.qameta.allure.Step;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.ValidPort;
import org.openqa.selenium.By;

public class MyHousesPage {
    private final GUIDriver driver;
    private final String MyHPEndPoint="/myhouses";
    public MyHousesPage(GUIDriver driver){
        this.driver=driver;
    }
    private final By addHouseButton= By.xpath("//button[@routerlink='/addhouse']");
    private final By yourHouse= By.xpath("//h1[.='Your Houses']");
    private final By noHousesMsg= By.xpath("//h3[@class='mt-4 text-lg font-medium text-gray-900']");
    @Step("navigate to my houses page")
    public MyHousesPage navigateToMyHousesPage(){
        driver.browser().navigateToUrl(PropertyReader.getProperty("baseUrlWeb")+MyHPEndPoint);
        return this;
    }
    @Step("add houses")
    public AddHousesPage addNewHouse(){
        driver.element().click(addHouseButton);
        return new AddHousesPage(driver);
    }

    //validations
    @Step("validate user in right page")
    public MyHousesPage validateMyHousesPage(){
        String Msg=driver.element().getText(yourHouse);
        new Verification().equals(Msg,"Your Houses","you're in wrong page couldn't assert My houses page");
    return this;
    }
    @Step("validate my house page is empty")
    public MyHousesPage validateEmptyMyHouses(){
        String Msg=driver.element().getText(noHousesMsg);
        new Verification().equals(Msg,"You haven't listed any properties yet","list is not empty");
        return this;
    }
}
