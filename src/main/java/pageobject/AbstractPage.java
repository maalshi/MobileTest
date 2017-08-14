package pageobject;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverManager;

public class AbstractPage {

    private int timeToWaitForElement = 30;
    private int fingers = 1;
    private int duration = 100;
    protected WebDriverWait wait;

    public void waitElement (MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void tapElement (MobileElement element){
        try {
            element.tap(fingers, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
