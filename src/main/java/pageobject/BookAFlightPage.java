package pageobject;

import businessobject.WaitForElement;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BookAFlightPage {

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text = 'ONE WAY']")
    private MobileElement tabOneWay;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text = 'RETURN']")
    private MobileElement tabReturn;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement buttonFlightFrom;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
    private MobileElement buttonFlightTo;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")
    private MobileElement buttonSelectDepartingDate;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout//android.widget.RelativeLayout/android.widget.ImageButton[2]")
    private MobileElement arrowIncreaseNumberOfAdults;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageButton")
    private MobileElement arrowDecreaseNumberOfAdults;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.EditText")
    private MobileElement numberOfAdults;

    @AndroidFindBy(xpath = "//android.widget.Button[@text = 'Search Flights']")
    private MobileElement buttonSearchFlights;

    private int fingers = 1;
    private int duration = 100;

    WaitForElement waitForElement = new WaitForElement();

    public void clickTabOneWay() {

        waitForElement.toBeClickable(tabOneWay);

        System.out.println("Click on the button 'Flight From'");

        try {
            tabOneWay.tap(fingers, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Button 'Flight From' has been clicked");

    }

    public void clickTabReturn() {

        waitForElement.toBeClickable(tabReturn);

        System.out.println("Click on the button 'Flight From'");

        try {
            tabReturn.tap(fingers, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Button 'Flight From' has been clicked");

    }

    public void clickButtonBookAFlightFrom() {

        waitForElement.toBeClickable(buttonFlightFrom);

        System.out.println("Click on the button 'Flight From'");

        try {
            buttonFlightFrom.tap(fingers, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Button 'Flight From' has been clicked");

    }

    public void clickButtonBookAFlightTo() {

        waitForElement.toBeClickable(buttonFlightTo);

        System.out.println("Click on the button 'Flight From'");

        try {
            buttonFlightTo.tap(fingers, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Button 'Flight From' has been clicked");

    }

    public void clickButtonSelectDepartingDate() {

        waitForElement.toBeClickable(buttonSelectDepartingDate);

        System.out.println("Click on the button 'Flight From'");

        try {
            buttonSelectDepartingDate.tap(fingers, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Button 'Flight From' has been clicked");

    }

    public void clickArrowToIncreaseNumberOfAdults(int number) {

        waitForElement.toBeClickable(arrowIncreaseNumberOfAdults);

        System.out.println("Click on the button 'Flight From'");

        try {

            if (Integer.parseInt(numberOfAdults.getText()) <= number) {
                for (int i = 1; i <= (number - 1); i++) {
                    arrowIncreaseNumberOfAdults.tap(fingers, duration);
                }

            } else if (Integer.parseInt(numberOfAdults.getText()) == number) {
                System.out.println("number Of Adults is already " + number);
            } else if (Integer.parseInt(numberOfAdults.getText()) > number) {
                System.out.println("number Of Adults is already more than " + number);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Button 'Flight From' has been clicked");

    }

    public void clickButtonSearchFlights() {

        waitForElement.toBeClickable(buttonSearchFlights);

        System.out.println("Click on the button 'Flight From'");

        try {
            buttonSearchFlights.tap(fingers, duration);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Button 'Flight From' has been clicked");

    }

}
