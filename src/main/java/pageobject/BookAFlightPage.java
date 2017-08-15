package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import webdriver.DriverManager;

public class BookAFlightPage extends AbstractPage {



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

    public BookAFlightPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    public void clickTabOneWay() {
        waitElement(tabOneWay);
        System.out.println("Click on the button 'One Way'");
        tapElement(tabOneWay);
        System.out.println("Button 'One Way' has been clicked");

    }

    public void clickTabReturn() {
        waitElement(tabReturn);
        System.out.println("Click on the button 'Flight From'");
        tapElement(tabReturn);
        System.out.println("Button 'Flight From' has been clicked");
    }

    public void clickButtonBookAFlightFrom() {
        waitElement(buttonFlightFrom);
        System.out.println("Click on the button 'Flight From'");
        tapElement(buttonFlightFrom);
        System.out.println("Button 'Flight From' has been clicked");
    }

    public void clickButtonBookAFlightTo() {
        waitElement(buttonFlightTo);
        System.out.println("Click on the button 'Flight To'");
        tapElement(buttonFlightTo);
        System.out.println("Button 'Flight To' has been clicked");
    }

    public void clickButtonSelectDepartingDate() {
        waitElement(buttonSelectDepartingDate);
        System.out.println("Click on the button 'Flight From'");
        tapElement(buttonSelectDepartingDate);
        System.out.println("Button 'Flight From' has been clicked");

    }

    public void clickArrowToIncreaseNumberOfAdults(int number) {
        waitElement(arrowIncreaseNumberOfAdults);
        System.out.println("Increase number of pax to 3");
        try {
            if (Integer.parseInt(numberOfAdults.getText()) <= number) {
                for (int i = 1; i <= (number - 1); i++) {
                    tapElement(arrowIncreaseNumberOfAdults);
                }
            } else if (Integer.parseInt(numberOfAdults.getText()) == number) {
                System.out.println("number Of Adults is already " + number);
            } else if (Integer.parseInt(numberOfAdults.getText()) > number) {
                System.out.println("number Of Adults is already more than " + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Number of pax is increased to 3");
    }

    public void clickButtonSearchFlights() {
       waitElement(buttonSearchFlights);
        System.out.println("Click on the button 'Search Flights'");
        tapElement(buttonSearchFlights);
        System.out.println("Button 'Search Flights' has been clicked");
    }
}
