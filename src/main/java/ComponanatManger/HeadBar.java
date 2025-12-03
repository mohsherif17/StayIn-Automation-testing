package ComponanatManger;

import Drivers.GUIDriver;
import Utils.DataReader.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HeadBar {
    protected final GUIDriver driver;

    public HeadBar(GUIDriver driver) {
        this.driver = driver;
    }

    private final By HomeIcon = By.xpath("//div/a[@href='/home'][2]");
    private final By Search = By.tagName("input");

    private final By ListIcon = By.xpath("//div/button[@class='flex text-sm bg-gray-100 rounded-full p-3 hover:bg-gray-200 shadow-lg transition-all duration-200']");
    private final By ListIconLog = By.xpath("//div/button[@class='flex items-center gap-2 text-sm bg-gray-100 rounded-full p-1 pr-3 hover:bg-gray-200 shadow-lg transition-all duration-200']");
    private final By LoginLink = By.xpath("//li/a[@href='/auth/login']");
    private final By RegisterLink = By.xpath("//li/a[@href='/auth/register']");
    private final By MyHousesLink = By.xpath("//li/a[@href='/myhouses']");
    private final By MyWishlistLink = By.xpath("//li/a[@href='/wishlist']");
    private final By WalletLink = By.xpath("//li/a[@href='/wallet']");
    private final By MyTripsLink = By.xpath("//li/a[@href='/my-trips']");
    private final By ChatLink = By.xpath("//li/a[@href='/chat']");
    private final By ProfileLink = By.xpath("//li/a[@href='/profile']");
    private final By AddHouseLink = By.xpath("//li/a[@href='/addhouse']");
    private final By SignOutLink = By.xpath("//li/a[.='Sign out']");

    @Step("navigate to Stay-In home Page")
    public HomePage navigateTOHomePage() {
        driver.browser().navigateToUrl(PropertyReader.getProperty("baseUrlWeb"));
        return new HomePage(driver);
    }

    @Step("search for item {name}")
    public HomePage searchForItem(String name) {
        driver.element().type(Search, name).pressEnter(Search);
        return new HomePage(driver);
    }
    @Step("navigate to login page")
    public LoginPage userLogin() {
        driver.element().click(ListIcon).click(LoginLink);
        return new LoginPage(driver);
    }
    @Step("navigate to register Page")
    public RegisterPage userRegister() {
        driver.element().click(ListIcon).click(RegisterLink);
        return new RegisterPage(driver);
    }
    @Step("sign out")
    public HomePage userSignOut() {
        driver.element().click(ListIconLog).click(SignOutLink);
        return new HomePage(driver);
    }
    @Step("navigate to my wish list page")
    public MyWishListPage userWishList() {
        driver.element().click(ListIconLog).click(MyWishlistLink);
        return new MyWishListPage(driver);
    }
    @Step("navigate to my wallet page")
    public WalletPage userWallet() {
        driver.element().click(ListIconLog).click(WalletLink);
        return new WalletPage(driver);
    }
    @Step("navigate to my Houses page")
    public MyHousesPage userHouses() {
        driver.element().click(ListIconLog).click(MyHousesLink);
        return new MyHousesPage(driver);
    }
    @Step("navigate to edit profile page")
    public ProfilePage userProfile() {
        driver.element().click(ListIconLog).click(ProfileLink);
        return new ProfilePage(driver);
    }
    @Step("navigate to my user trips page")
    public MyTripsPage userTrips() {
        driver.element().click(ListIconLog).click(MyTripsLink);
        return new MyTripsPage(driver);
    }
    @Step("navigate to chat page")
    public ChatPage userChat(){
        driver.element().click(ListIconLog).click(ChatLink);
        return new ChatPage(driver);
    }
    @Step("navigate to Add Houses page")
    public AddHousesPage addHousePage() {
        driver.element().click(ListIconLog).click(AddHouseLink);
        return new AddHousesPage(driver);
    }


}
