package ComponanatManger;

import Drivers.GUIDriver;
import Utils.DataReader.PropertyReader;
import Validations.Verification;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WalletPage {
    private final GUIDriver driver;
    private final String MyWEndPoint = "/wallet";

    public WalletPage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By totalEarnings = By.xpath("//p[@class='text-2xl font-bold text-main']");

    @Step("navigate to my wallet page")
    public WalletPage navigateToMyWalletPage() {
        driver.browser().navigateToUrl(PropertyReader.getProperty("baseUrlWeb") + MyWEndPoint);
        return this;
    }

    @Step("validate total earnings")
    public WalletPage validateTotalEarnings(String TotalEarnings) {
        String ActualEarnings = driver.element().getText(totalEarnings);
        new Verification().equals(ActualEarnings, TotalEarnings, "earnings are no equal");
        return this;
    }
}
