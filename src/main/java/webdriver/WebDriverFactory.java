package webdriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Factory for WebDriver instances
 */
public interface WebDriverFactory {
    /**
     * Creates new WebDriver instance
     *
     * @throws Exception
     */
    AppiumDriver<MobileElement> createWebDriver() throws Exception;

}
