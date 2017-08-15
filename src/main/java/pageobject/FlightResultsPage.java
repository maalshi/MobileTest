package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import webdriver.DriverManager;

public class FlightResultsPage extends AbstractPage {

    @AndroidFindBy(id = "com.aerlingus.mobile:id/going_flight_item_destination_code_text_view")
    private MobileElement flightResultsDestAirport;

    @AndroidFindBy(id = "com.aerlingus.mobile:id/going_flight_item_origin_code_text_view")
    private MobileElement flightResultsOrigAirport;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Dublin to London/Heathrow']")
    private MobileElement OrigAndDestin;

    public FlightResultsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public static void assertEquals(String actual, String expected){
        System.out.println("Assert that actual [" + actual + "] equals expected [" + expected + "]");
        Assert.assertEquals(actual, expected);
    }

    public String getOriginAndDestinationText(){
        waitElement(OrigAndDestin);
        return OrigAndDestin.getText();
    }
}
