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
@Feature("E2E Test for property Reservation")
@Story("navigate to the home page, login, search for a property, " +
        "add to wishlist, filter items, select a property, " +
        "make a reservation, and complete payment.")
@Severity(SeverityLevel.CRITICAL)
@Owner("Muhammed Sherif")
public class E2E extends BaseTest {
    GUIDriver driver;
    HeadBar HeadbarComp;

    @Test
    void LoginTc() {
        HeadbarComp.userLogin()
                .enterEmail(testData.getJsonData("user1.email"))
                .enterPassword(testData.getJsonData("user1.password"))
                .submitForm();
    }


    @Test(dependsOnMethods = {"LoginTc"})
    void searchTC() {
        HeadbarComp.searchForItem(testData.getJsonData("searchProperty")).
                viewNextImage(testData.getJsonData("searchProperty")).
                viewNextImage(testData.getJsonData("searchProperty")).
                viewNextImage(testData.getJsonData("searchProperty")).
                viewPreviousImage(testData.getJsonData("searchProperty")).
                addToWishList(testData.getJsonData("searchProperty"));
    }

    @Test(dependsOnMethods = {"LoginTc", "searchTC"})
    void wishListTc() {
        HeadbarComp.userWishList()
                .validateItemAdded(testData.getJsonData("searchProperty"));
    }


    @Test(dependsOnMethods = {"LoginTc", "searchTC", "wishListTc"})
    void selectProductFromFilter() {
        HeadbarComp.navigateTOHomePage()
                .filterItems(testData.getJsonData("filterItem"))
                .viewNextImage(testData.getJsonData("filterProperty"))
                .viewNextImage(testData.getJsonData("filterProperty"))
                .viewNextImage(testData.getJsonData("filterProperty"))
                .viewPreviousImage(testData.getJsonData("filterProperty")).
                selectProperty(testData.getJsonData("filterProperty"));
    }


    @Test(dependsOnMethods = {"LoginTc", "searchTC", "wishListTc", "selectProductFromFilter"})
    void viewPropertyTC() {
        new PropertyPage(driver)
                .ChoseDate(testData.getJsonData("reservationProp.checkIn"))
                .choseFromNxtMonth(testData.getJsonData("reservationProp.checkOut"))
                .openGuestNumber()
                .increaseAdults(testData.getJsonData("reservationProp.adults"))
                .decreaseAdults(testData.getJsonData("reservationProp.adults"))
                .increaseChildren(testData.getJsonData("reservationProp.children"))
                .increaseInfants(testData.getJsonData("reservationProp.infants"))
                .addPet()
                .closeGuestsSec()
                .showAllOptions()
                .validatePropertyOptionFromMenu(testData.getJsonData("reservationProp.option3"))
                .validatePropertyOptionFromMenu(testData.getJsonData("reservationProp.option1"))
                .dismissMenu().validateNightPrice(testData.getJsonData("reservationProp.nPrice"))
                .validateTotalPrice(testData.getJsonData("reservationProp.Total"))
                .completeReservation();


    }

    @Test(dependsOnMethods = {"LoginTc", "searchTC", "wishListTc",
            "selectProductFromFilter", "viewPropertyTC"})
    void completePaymentTC() {
        new PaymentPage(driver).enterEmail(testData.getJsonData("card.email"))
                .enterCardnumber(testData.getJsonData("card.number"))
                .enterExpDate(testData.getJsonData("card.ExDate"))
                .enterCvc(testData.getJsonData("card.CVV"))
                .enterCardHolder(testData.getJsonData("card.holder"))
                .submitPayment();
    }

    @Test(dependsOnMethods = {"LoginTc", "searchTC", "wishListTc", "selectProductFromFilter",
            "viewPropertyTC", "completePaymentTC"})
    void validateSuccessfulPaymentTC() {
        new ComponanatManger.succefulPaymentPage(driver)
                .validateSuccessMSG(testData.getJsonData("payment.message"))
                .validateTotalPaid(testData.getJsonData("payment.total"))
                .validateReservationDates(testData.getJsonData("payment.date"))
                .returnToHomePage();
    }


    @BeforeClass
    void beforeClassConditions() {
        testData = new JsonReader("E2E-Data");
        driver = new GUIDriver();
        HeadbarComp = new HeadBar(driver);
        HeadbarComp.navigateTOHomePage();
        LogsManager.info("before test register test");
    }

    @AfterClass
    public void TearDown() {
        driver.quitDriver();
        LogsManager.info("after test register test");
    }

}
