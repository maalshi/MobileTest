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
    DestinationPage destination = new DestinationPage();
    BookAFlightPage booking = new BookAFlightPage();

    @BeforeClass
    public void beforeTest() {

        try {
            DriverManager.createWedDriverForDevice();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void newTestDemo() {
        MainPage mainpage = new MainPage();
        mainpage.clickButtonBookAFlight();

        BookAFlightPage book = new BookAFlightPage();
        book.clickTabOneWay();
        book.clickButtonBookAFlightTo();
    }
    @Parameters({ "airport" })
    @Test
    public void enterDestination (String airport){
        destination.searchForAirports(airport);
        destination.selectAirportAfterSearch();
        booking.clickButtonSearchFlights(); }

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
