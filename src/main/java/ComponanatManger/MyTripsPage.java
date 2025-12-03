package ComponanatManger;

import Drivers.GUIDriver;
import Utils.DataReader.PropertyReader;
import Validations.Validation;
import Validations.Verification;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyTripsPage {
    private final GUIDriver driver;
    private final String MTEndPoint = "/my-trips";

    public MyTripsPage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By TripsSummary = By.xpath("//h2[.='Trips Summary']/following::p[@class='text-gray-600'][1]");
    private final By TotalSpending = By.xpath("//div/p[@class='text-2xl font-bold text-main']");

    private By tripLocation(String name) {
        return By.xpath("//h3[.='" + name + "']");
    }

    private By tripPrice(String name) {
        return By.xpath("//h3[.='" + name + "']/following::p[3]");
    }

    @Step("navigate to my trips page")
    public MyTripsPage navigateToMyTripsPage() {
        driver.browser().navigateToUrl(PropertyReader.getProperty("baseUrlWeb") + MTEndPoint);
        return this;
    }

    @Step("validate the number of user trips")
    public MyTripsPage validateNumberOfTrips(String number) {
        String ActualNumber = driver.element().getText(TripsSummary);
        new Verification().equals(ActualNumber, number, "number miss match");
        return this;
    }

    @Step("validate the Total spent by the user")
    public MyTripsPage validateTotalSpending(String price) {
        String ActualNumber = driver.element().getText(TotalSpending);
        new Verification().equals(ActualNumber, price, "number miss match");
        return this;
    }

    @Step("validate trips destination and price")
    public MyTripsPage validateTripLocationPrice(String Location, String expectedPrice) {
        String accLocation = driver.element().getText(tripLocation(Location));
        String accPrice = driver.element().getText(tripPrice(Location));
        new Validation().equals(accLocation, Location, "location miss match");
        new Validation().equals(accPrice, expectedPrice, "price Miss Match");
        return this;
    }

}