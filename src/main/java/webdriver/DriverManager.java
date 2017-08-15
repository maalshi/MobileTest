package webdriver;


import org.openqa.selenium.remote.SessionNotFoundException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import webdriver.TestProperties;

public class DriverManager {

    // private final static Logger logger =
    // Logger.getLogger(WebDriverFactoryManager.class);

    private static String platformName = TestProperties.getInstance().getPlatformName();
    private static boolean saucelabsEmulator = TestProperties.getInstance().getSaucelabsEmulator();
    private static WebDriverFactory result;
    static AppiumDriver<MobileElement> driver;

    public String getDefaultPlatformName() {
        return platformName;
    }

    public boolean getSaucelabsEmulator() {
        return saucelabsEmulator;
    }

    public DriverManager() {
    }

    public static AppiumDriver<MobileElement> createWedDriverForDevice() throws Exception {
        // logger.info("Creating WebDriver instance by Type: '" + browserType +
        // "'");

        System.out.println(platformName);
        System.out.println(saucelabsEmulator);

        if ((platformName.equals("Android")) & (saucelabsEmulator == false)) {
            System.out.println("in if Android desctop");
            result = new AndroidDriverFactoryDesctop();
        } else if ((platformName == "Android") & (saucelabsEmulator == true)) {
            System.out.println("in if Android saucelabs");
            result = new AndroidDriverFactorySaucelabs();
        } else {
            // throw new ItemNotFoundException("There is no WebDriverFactory
            // implementation for '"
            // + browserType.name() + "'");
        }
        System.out.println("result is " + result);
        System.out.println("after if");
        driver = result.createWebDriver();
        return driver;

    }

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static void closeDriver() {
        AppiumDriver<MobileElement> runDriver = driver;
        try {
            if (runDriver != null)
                System.out.println("befor close driver1" + runDriver);
            runDriver.quit();
            System.out.println("after close driver1");
        } catch (SessionNotFoundException e) {
        }

    }

}