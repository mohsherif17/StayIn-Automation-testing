package ComponanatManger;

import Drivers.GUIDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {
    private final GUIDriver driver;

    public HomePage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By desertFilter=By.xpath("//button/span[.='Desert']");
    private final By CampingFilter=By.xpath("//button/span[.='Camping']");
    private final By MountainFilter=By.xpath("//button/span[.='Mountain']");
    private final By CityFilter=By.xpath("//button/span[.='City']");
    private final By FarmsFilter=By.xpath("//button/span[.='Farms']");
    private final By BoatsFilter=By.xpath("//button/span[.='Boats']");
    private final By BeachFilter=By.xpath("//button/span[.='Beach']");
    private final By LakeFilter=By.xpath("//button/span[.='Lake']");
    private final By RoomFilter=By.xpath("//button/span[.='Room']");
    private final By TowersFilter=By.xpath("//button/span[.='Towers']");
    private final By BarnsFilter=By.xpath("//button/span[.='Barns']");
    private final By forestFilter=By.xpath("//button/span[.='forest']");

    private By filterBar(String filter){
        return By.xpath("//button/span[.='"+filter+"']");
    }

    private By propertyName(String name) {
        return  By.xpath("//div/h3[.='" + name + "']");
    }

    private By nextImageButton(String name) {
        return  By.xpath("//div/h3[.='" + name + "']/preceding::button[@aria-Label='Next image']");
    }

    private By previousImageButton(String name) {
        return  By.xpath("//div/h3[.='" + name + "']/preceding::button[@aria-Label='Previous image']");
    }
    private By addToWishListButton(String name) {
        return By.xpath("//div/h3[.='" + name + "']/preceding::button[@aria-Label='Add to wishlist']");
    }

    @Step("add filter {filter} to items")
    public HomePage filterItems(String filter){
        driver.element().click(filterBar(filter));
        return this;
    }
    @Step("add {name} to user wishlist")
    public HomePage addToWishList(String name){
        driver.element().click(addToWishListButton(name));
        return this;
    }
    @Step("navigate throw next photos")
    public HomePage viewNextImage(String name){
        driver.element().click(nextImageButton(name));
        return this;
    }
    @Step("navigate throw previous photos")
    public HomePage viewPreviousImage(String name){
        driver.element().click(previousImageButton(name));
        return this;
    }
    @Step("select {name} from displayed properties")
    public HomePage selectProperty(String name){
        driver.element().click(propertyName(name));
        return this;
    }
}
