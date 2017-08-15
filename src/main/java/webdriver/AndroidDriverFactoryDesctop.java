package webdriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverFactoryDesctop implements WebDriverFactory {

    public static final String USERNAME = "Mobtest1";
    public static final String ACCESS_KEY = "fc4e812f-4501-49e4-9b19-6195e5910d57";
    public static final String URL = TestProperties.getInstance().getAppiumURL();

    public AppiumDriver<MobileElement> createWebDriver() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "C:\\Users\\Shand\\Desktop\\eiandroid.apk");
        capabilities.setCapability("deviceName", "192.168.83.101:5555");
        capabilities.setCapability("newCommandTimeout", 360);

        System.out.println("Driver before creation in the factory");

        System.out.println("befor driver" + URL);
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL(URL), capabilities);

        System.out.println("after create a driver");

        driver.manage().timeouts().implicitlyWait(420, TimeUnit.SECONDS);
        driver.context("NATIVE_APP");
        System.out.println(driver + " is cteated new Driver driver");

        return driver;
    }

}
