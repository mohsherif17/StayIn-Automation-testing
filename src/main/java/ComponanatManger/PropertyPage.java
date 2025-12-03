package ComponanatManger;

import Drivers.GUIDriver;
import Utils.Actions.ElementActionManger;
import Validations.Verification;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import javax.swing.*;

public class PropertyPage {
    private final GUIDriver driver;

    public PropertyPage(GUIDriver driver) {
        this.driver = driver;
    }

    private final By nextMonthBtn = By.xpath("//div[@class='flex space-x-8']/preceding::button[@class='p-2 rounded-full hover:bg-gray-100']");
    private final By previousMonthBtn = By.xpath("//div[@class='flex space-x-8']/following::button[@class='p-2 rounded-full hover:bg-gray-100']");
    private final By ClearDatesBtn = By.xpath("//button[.=' Clear dates ']");
    private final By reserveBtn = By.xpath("//button[.=' Reserve ']");
    private final By checkInDate = By.xpath("//label[.='CHECK-IN']/following::div[@class='text-sm'][1]");
    private final By checkOutDate = By.xpath("//label[.='CHECKOUT']/following::div[@class='text-sm'][1]");
    private final By nxtMonthBtn = By.xpath("//button[@class='p-1 rounded-full hover:bg-gray-100'][2]");
    private final By prevMonthBtn = By.xpath("//button[@class='p-1 rounded-full hover:bg-gray-100'][1]");
    private final By nightPrice = By.xpath("//app-booking/div/div/div/span[@class='text-2xl font-semibold']");
    private final By totalPrice = By.xpath("//app-booking/div/div/span[.='Total']/following::span[@class='font-semibold']");
    private final By numberOfGuests = By.xpath("//label[.='GUESTS']/following::div[@class='text-sm cursor-pointer']");
    private final By increaseAdults = By.xpath("//div[.='Adults']/following::button[.=' + '][1]");
    private final By increaseChildren = By.xpath("//div[.='Children']/following::button[.=' + '][1]");
    private final By increaseInfants = By.xpath("//div[.='Infants']/following::button[.=' + '][1]");
    private final By decreaseAdults = By.xpath("//div[.='Adults']/following::button[.=' - '][1]");
    private final By decreaseChildren = By.xpath("//div[.='Children']/following::button[.=' - '][1]");
    private final By ServPetsBtn = By.xpath("//div/label[@class='relative inline-flex items-center cursor-pointer']");
    private final By decreaseInfants = By.xpath("//div[.='Infants']/following::button[.=' - '][1]");
    private final By closeGuests = By.xpath("//button[.=' Close ']");
    private final By doneBtn = By.xpath("//button[.=' Done ']");
    private final By ShowAllOptions=By.xpath("//app-amenities//button");
    private final By optionsDone=By.xpath("//app-amenities//button[.=' Done ']");
    private By selectDay(String day) {
        return By.xpath("//div[@class='grid grid-cols-7 gap-1']/preceding::button[.=' " + day + " ']");
    }

    private By selectDayFromAppBooking(String day) {
        return By.xpath("//div[@class='text-center p-2 rounded-full text-sm cursor-pointer'][.=' " + day + " ']");
    }

    private By catchOptions(String name) {
        return By.xpath("//app-amenities//span[.='" + name + "']");
    }
    private By catchOptionsFromMenu(String name) {
        return By.xpath("//app-amenities//p[.='" + name + "']");
    }

@Step("choose next month for reservation")
    public PropertyPage moveToNextMonth() {
        driver.element().click(nextMonthBtn);
        return this;
    }
@Step("choose previous month for reservation")
public PropertyPage moveToPreviousMonth() {
        driver.element().click(previousMonthBtn);
        return this;
    }
@Step("select check in/out date")
    public PropertyPage ChoseDate(String day) {
        driver.element().click(selectDay(day));
        return this;
    }
    @Step("clear dates Selection")
    public PropertyPage clearSelectedDates(){
        driver.element().click(ClearDatesBtn);
        return this;
    }
@Step("select check in date")
    public PropertyPage choseCheckInDate(String day) {
        driver.element().click(checkInDate).click(selectDayFromAppBooking(day)).click(doneBtn);
        return this;
    }
@Step("select check out date")
    public PropertyPage choseCheckOutDate(String day) {
        driver.element().click(checkOutDate).click(selectDayFromAppBooking(day)).click(doneBtn);
        return this;
    }
@Step("choose next month for reservation")
    public PropertyPage moveToNxtMonth() {
        driver.element().click(nxtMonthBtn);
        return this;
    }
@Step("choose previous month for reservation")
public PropertyPage moveToPrevMonth() {
        driver.element().click(prevMonthBtn);
        return this;
    }
@Step("open Guests details to modify numbers")
    public PropertyPage openGuestNumber() {
        driver.element().click(numberOfGuests);
        return this;
    }
@Step("increase the number of adults for reservation")
    public PropertyPage increaseAdults(String number) {
        int x = Integer.parseInt(number);
        for ( int i = 0; i < x ; i++) {
            driver.element().click(increaseAdults);
        }
        return this;
    }
@Step("decrease the number of adults for reservation")
    public PropertyPage decreaseAdults(String number) {
        int x = Integer.parseInt(number);
        for ( int i = 0; i < x ; i++) {
            driver.element().click(decreaseAdults);
        }
        return this;
    }
@Step("increase the number of Children for reservation")
    public PropertyPage increaseChildren(String number) {
        int x = Integer.parseInt(number);
        for ( int i = 0; i < x ; i++) {
            driver.element().click(increaseChildren);
        }
        return this;
    }
    @Step("decrease the number of Children for reservation")
    public PropertyPage decreaseChildren(String number) {
        int x = Integer.parseInt(number);
        for ( int i = 0; i < x ; i++) {
            driver.element().click(decreaseChildren);
        }
        return this;
    }
    @Step("increase the number of infants for reservation")
    public PropertyPage increaseInfants(String number) {
        int x = Integer.parseInt(number);
        for ( int i = 0; i < x ; i++) {
            driver.element().click(increaseInfants);
        }
        return this;
    }
    @Step("decrease the number of infants for reservation")
    public PropertyPage decreaseInfants(String number) {
        int x = Integer.parseInt(number);
        for ( int i = 0; i < x ; i++) {
            driver.element().click(decreaseInfants);
        }
        return this;
    }
@Step("add service pet")
    public PropertyPage addPet() {
        driver.element().click(ServPetsBtn);
        return this;
    }
@Step("close the guests details after completing details")
    public PropertyPage closeGuestsSec() {
        driver.element().click(closeGuests);
        return this;
    }
@Step("confirm the details and proceed to payment")
    public PaymentPage completeReservation() {
        driver.element().click(reserveBtn);
        return new PaymentPage(driver);
    }
    @Step("open property options menu")
    public PropertyPage showAllOptions(){
        driver.element().click(ShowAllOptions);
        return this;
    }
    @Step("close property options menu")
    public PropertyPage dismissMenu(){
        driver.element().click(optionsDone);
        return this;
    }
    @Step("validate options exists")
    public PropertyPage validatePropertyOptionFromMenu(String option) {
        String accOption = driver.element().getText(catchOptionsFromMenu(option));
        new Verification().equals(accOption, option, "option not found in this property");
        return this;
    }
@Step("validate the night total price")
    public PropertyPage validateNightPrice(String price) {
        String accPrice = driver.element().getText(nightPrice);
        new Verification().equals(accPrice, price, "price is not correct");
        return this;
    }
@Step("validate the reservation total price")
    public PropertyPage validateTotalPrice(String price) {
        String accPrice = driver.element().getText(totalPrice);
        new Verification().equals(accPrice, price, "price is not correct");
        return this;
    }
@Step("validate the property options")
    public PropertyPage validatePropertyOption(String option) {
        String accOption = driver.element().getText(catchOptions(option));
        new Verification().equals(accOption, option, "option not found in this property");
        return this;
    }
@Step("validate error message for reserving without valid dates")
    public PropertyPage validateReserveWithoutDates() {
        String alertText = driver.element().getAlertText();
        new Verification().equals(alertText, "Please select check-in and check-out dates", "no alert displayed");
        driver.element().acceptAlert();
        return this;
    }

}