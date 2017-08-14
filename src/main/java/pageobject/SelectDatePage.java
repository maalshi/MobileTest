package pageobject;

import businessobject.WaitForElement;
import businessobject.dates.BookingDate;
import businessobject.dates.SwipeSelectDatePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import webdriver.DriverManager;

public class SelectDatePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Done']")
    private MobileElement buttonDone;

    private AndroidDriver driver;
    private String dayXPath;

    public SelectDatePage() {
        this.driver = (AndroidDriver) DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    WaitForElement waitForElement = new WaitForElement();

    public void clickOnTheDay(BookingDate bookingDate) {

        SwipeSelectDatePage swipe = new SwipeSelectDatePage();
        swipe.swipeDownToFindDay(driver, bookingDate);
        dayXPath = swipe.createDayXpath(bookingDate);
        AndroidElement day;

        try {
            day = (AndroidElement) driver.findElement(By.xpath(dayXPath));
            waitForElement.toBeClickable(day);
            day.tap(1, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickButtonDone() {

        waitForElement.toBeClickable(buttonDone);

        System.out.println("Click on the button 'Done'");

        try {
            buttonDone.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Button 'Done' has been clicked");

    }

}
