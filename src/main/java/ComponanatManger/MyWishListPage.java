package ComponanatManger;

import Drivers.GUIDriver;
import Utils.DataReader.PropertyReader;
import Validations.Validation;
import Validations.Verification;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyWishListPage {
    private final GUIDriver driver;
    private final String MyWLEndPoint="/wishlist";
    public MyWishListPage(GUIDriver driver){
        this.driver=driver;
    }

    private final By ExplorePropetiesButton= By.xpath("//div/a[.=' Explore Properties ']");
    private final By yourWishList= By.xpath("//h1[.='Your Wishlist']");
    private final By noPropMsg= By.xpath("//h3[.='No properties saved yet']");
    private By propertyName(String name) {
        return  By.xpath("//div/h3[.='" + name + "']");
    }

    @Step("navigate to my wishlist page")
    public MyWishListPage navigateToWishListPage(){
        driver.browser().navigateToUrl(PropertyReader.getProperty("baseUrlWeb")+MyWLEndPoint);
        return this;
    }

    @Step("navigate to home page to add more properties to the wishlist")
    public HomePage exploreProperties(){
        driver.element().click(ExplorePropetiesButton);
        return new HomePage(driver);
    }

    //validations
    @Step("validate right page")
    public MyWishListPage validateWishlistPage(){
        String Msg=driver.element().getText(yourWishList);
        new Verification().equals(Msg,"Your Wishlist","you're in wrong page couldn't assert wishlist page");
        return this;
    }
    @Step("validate the list is empty")
    public MyWishListPage validateEmptyWishList(){
        String Msg=driver.element().getText(noPropMsg);
        new Verification().equals(Msg,"No properties saved yet","list is not empty");
        return this;
    }
    @Step("validate item in wish list")
    public MyWishListPage validateItemAdded(String name){
        String item= driver.element().getText(propertyName(name));
        String Msg=driver.element().getText(yourWishList);
        new Validation().equals(Msg,"Your Wishlist","you're in wrong page couldn't assert wishlist page");
        new Validation().equals(item,name,"item is not added");
        return this;
    }
}
