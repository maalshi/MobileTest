import businessobject.dates.BookingDate;
import businessobject.dates.DefaultDate;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.*;
import webdriver.DriverManager;

public class FlightTest {
    DestinationPage destination = new DestinationPage();
    BookAFlightPage book = new BookAFlightPage();

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
        MainPage mainPage = new MainPage();
        mainPage.clickButtonBookAFlight();
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
        book.clickButtonBookAFlightTo();

    }
    @Parameters({ "airport" })
    @Test
    public void enterDestination (String airport){
        destination.searchForAirports(airport);
        destination.selectAirportAfterSearch();
        book.clickButtonSearchFlights();

        FlightResultsPage results = new FlightResultsPage();
        results.assertEquals(results.getOriginAndDestinationText(),"Dublin to London/Heathrow");
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
