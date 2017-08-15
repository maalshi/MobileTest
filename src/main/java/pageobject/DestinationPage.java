package pageobject;

import businessobject.Destination;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import webdriver.DriverManager;

public class DestinationPage extends AbstractPage {

    public void initialisePageObject(Object page) {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), page);
    }

    @AndroidFindBy(id = "com.aerlingus.mobile:id/searchTextView")
    private MobileElement searchForAirports;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.ListView/android.widget.LinearLayout[2]")
    private MobileElement foundAirport;

    @AndroidFindBy(id = "com.aerlingus.mobile:id/going_flight_item_destination_code_text_view")
    private MobileElement flightResultsDestAirport;

    @AndroidFindBy(id = "com.aerlingus.mobile:id/going_flight_item_origin_code_text_view")
    private MobileElement flightResultsOrigAirport;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Dublin to London/Heathrow']")
    private MobileElement OrigAndDestin;

    public void searchForAirports(String airport) {

        waitElement(searchForAirports);
        System.out.println("Click on the searchForAirports");
        try {
            searchForAirports.sendKeys(Destination.getDestination());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Button searchForAirports has been clicked");
    }

    public void selectAirportAfterSearch(){
        waitElement(foundAirport);
        System.out.println("Click on the selectAirportAfterSearch");
        tapElement(foundAirport);
        System.out.println("Button selectAirportAfterSearch has been clicked");
    }

    public String readAirportName(){
        return searchForAirports.getAttribute("value");
    }
}


