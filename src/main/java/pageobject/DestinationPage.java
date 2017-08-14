package pageobject;

import businessobject.Destination;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DestinationPage extends AbstractPage {

    @AndroidFindBy(id = "com.aerlingus.mobile:id/searchTextView")
    private MobileElement searchForAirports;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout//android.widget.ListView/android.widget.LinearLayout[2]")
    private MobileElement foundAirport;

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


