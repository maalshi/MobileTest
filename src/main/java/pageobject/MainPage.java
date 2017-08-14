package pageobject;

import businessobject.WaitForElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import webdriver.DriverManager;


public class MainPage {


        public MainPage() {
            PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
        }

        @AndroidFindBy(xpath = "//android.widget.Button[@text='Book a Flight']")
        private MobileElement buttonBookAFlight;

        @AndroidFindBy(xpath = "//android.widget.Button[@text='Flight Status']")
        private MobileElement buttonFlightStatus;

        @AndroidFindBy(xpath = "//android.widget.Button[@text='Check In']")
        private MobileElement buttonCheckIn;

        @AndroidFindBy(xpath = "//android.widget.Button[@text='Sign In']")
        private MobileElement buttonSignIn;

        @AndroidFindBy(xpath = "//android.widget.Button[@text='My Trips']")
        private MobileElement buttonMyTrips;

        @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/up']")
        private MobileElement buttonMenu;

        WaitForElement waitForElement = new WaitForElement();

        public void clickButtonBookAFlight() {

            waitForElement.toBeClickable(buttonBookAFlight);

            System.out.println("Click on the button 'Book a Flight'");

            try {
                buttonBookAFlight.click();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Button 'Book a Flight' has been clicked");

            // waitForElement.toBeClickable(readLaterIcon);

        }


}
