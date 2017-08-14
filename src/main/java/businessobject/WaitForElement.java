package businessobject;

import io.appium.java_client.MobileElement;

import webdriver.DriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

    private int timeToWaitForElement = 30;

    public void toBeClickable(MobileElement element) {
        try {
            (new WebDriverWait(DriverManager.getDriver(), timeToWaitForElement))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}