package ComponanatManger;

import Drivers.GUIDriver;
import Utils.DataReader.PropertyReader;
import Validations.Verification;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProfilePage {
    private final GUIDriver driver;
    private final String ProPageEndPoint = "/profile";

    public ProfilePage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By FirstName = By.id("firstName");
    private final By LastName = By.id("lastName");
    private final By Address = By.id("address");
    private final By DateOfBirth = By.id("dateOfBirth");
    private final By ProfileImage = By.xpath("//label[@for='profilePicture']");
    private final By SubmitBtn = By.xpath("//button[@type='submit']");
    private final By ChangesSaved = By.xpath("//div[@class='mb-4 p-4 bg-green-100 text-green-700 rounded']");

    @Step("navigate to user profile page")
    public ProfilePage navigateToProfilePage() {
        driver.browser().navigateToUrl(PropertyReader.getProperty("baseUrlWeb") + ProPageEndPoint);
        return this;
    }

    @Step("edit the user first name")
    public ProfilePage updateFirstName(String newFirstName) {
        driver.element().type(FirstName, newFirstName);
        return this;
    }

    @Step("edit the user's last name")
    public ProfilePage updateLastName(String newLastName) {
        driver.element().type(LastName, newLastName);
        return this;
    }

    @Step("edit user's address")
    public ProfilePage updateAddress(String newAddress) {
        driver.element().type(Address, newAddress);
        return this;
    }

    @Step("edit user birth date")
    public ProfilePage updateDateOfBirth(String newDateOfBirth) {
        driver.element().type(DateOfBirth, newDateOfBirth);
        return this;
    }

    @Step("upload a profile picture")
    public ProfilePage updateProfileImage(String newProfileImage) {
        driver.element().uploadPhoto(ProfileImage, newProfileImage);
        return this;
    }

    @Step("submit the changes")
    public ProfilePage submitChanges() {
        driver.element().click(SubmitBtn);
        return this;
    }

    @Step("validate changes saved message")
    public ProfilePage validateChangesSaved() {
        String Msg = driver.element().getText(ChangesSaved);
        new Verification().equals(Msg, "Profile updated successfully!", "message Miss Match");
        return this;
    }
}
