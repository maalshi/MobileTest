package webdriver;

import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import webdriver.WebDriverFactory;

//AndroidDriverFactorySaucelabs Does not work!!!
public class AndroidDriverFactorySaucelabs implements WebDriverFactory {

    public static final String USERNAME = "olgaopmob";
    public static final String ACCESS_KEY = "f119f2ea-74ef-4daf-a887-1a8939ab0290";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public synchronized AppiumDriver<MobileElement> createWebDriver() throws Exception {
        System.out.println("in driver");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", TestProperties.getInstance().getPlatformName());
        capabilities.setCapability("deviceName", "Samsung Galaxy S4 Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", "sauce-storage:eiandroid.apk");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("appiumVersion", "1.5.3");

        capabilities.setCapability("newCommandTimeout", 420);

        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL(URL), capabilities);
        System.out.println("after create a driver");

        System.out.println("in driver return");
        return driver;
    }

}
