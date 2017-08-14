package webdriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.*;

public class DriverManager {

    private DriverManager (){}

    private static final String URI_SCHEME = "http://";
    private static final String WD_SERVER_ROOT = "/wd/hub";
    private static final ThreadLocal<AppiumDriver> driverPool = new ThreadLocal<AppiumDriver>();

    public static void createAndroidDriver() throws Exception{
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability(NEW_COMMAND_TIMEOUT, "1200");
        caps.setCapability(DEVICE_READY_TIMEOUT, "120");
        caps.setCapability(LAUNCH_TIMEOUT, "120000");

        caps.setCapability(PLATFORM_NAME, "Android");
        caps.setCapability(DEVICE_NAME, "android_phone");

        AppiumDriver driver = new AndroidDriver(new URL(URI_SCHEME + "127.0.0.1:4273" + WD_SERVER_ROOT), caps);

        driverPool.set(driver);
        driverPool.get().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

    }

    public static AppiumDriver getDriver() {return driverPool.get();}
//---
    public static void closeDriver() {
        getDriver().closeApp();
    }
}
