import businessobject.dates.BookingDate;
import businessobject.dates.DefaultDate;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.BookAFlightPage;
import pageobject.DestinationPage;
import pageobject.MainPage;
import pageobject.SelectDatePage;
import webdriver.DriverManager;

public class FlightTest {

    @BeforeClass
    public void beforeMethod(){
        try {
            DriverManager.createAndroidDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    DestinationPage destination = new DestinationPage();
    @Parameters({ "airport" })
    @Test
    public void newTestDemo(String airport) {
        MainPage mainpage = new MainPage();
        mainpage.clickButtonBookAFlight();

        BookAFlightPage booking = new BookAFlightPage();
        booking.clickButtonSelectDepartingDate();
        BookingDate bookingFromDate = DefaultDate.CreateDefaultDate().withDay("25").withMonth("August");
        System.out.println(bookingFromDate.toString());
        SelectDatePage date = new SelectDatePage();
        date.clickOnTheDay(bookingFromDate);
        BookingDate bookingToDate = DefaultDate.CreateDefaultDate().withDay("5").withMonth("September");
        date.clickOnTheDay(bookingToDate);
        date.clickButtonDone();
        booking.clickArrowToIncreaseNumberOfAdults(3);
        booking.clickButtonBookAFlightTo();
        destination.searchForAirports(airport);
        destination.selectAirportAfterSearch();
        booking.clickButtonSearchFlights();
    }
//---
    @AfterClass
    public void afterTest() {

        try {
            DriverManager.closeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
