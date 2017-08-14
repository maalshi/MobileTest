package pageobject;

import businessobject.Destination;
import businessobject.WaitForElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DestinationPage {

    @AndroidFindBy(id = "com.aerlingus.mobile:id/searchTextView")
    private MobileElement searchForAirports;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.ListView/android.widget.LinearLayout[2]")
    private MobileElement foundAirport;

    private int fingers = 1;
    private int duration = 100;

    WaitForElement waitForElement = new WaitForElement();

    public void searchForAirports(String airport) {

        waitForElement.toBeClickable(searchForAirports);

        System.out.println("Click on the searchForAirports");

        try {
            searchForAirports.sendKeys(Destination.getDestination());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Button searchForAirports has been clicked");

    }

    public void selectAirportAfterSearch(){
        waitForElement.toBeClickable(foundAirport);

        System.out.println("Click on the selectAirportAfterSearch");

        try {
            foundAirport.tap(fingers, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Button selectAirportAfterSearch has been clicked");

    }

    public String readAirportName(){
        return searchForAirports.getAttribute("value");
    }
}


