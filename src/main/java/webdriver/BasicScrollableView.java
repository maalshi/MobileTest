package webdriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class BasicScrollableView {

    private AppiumDriver<MobileElement> driver;
    private boolean find = false;
    private String xPath;
    MobileElement element;

    public BasicScrollableView(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void scrollDown(String xpath) {
		/*
		 * Method verifies if chosen element is present on the page. If element
		 * does not present on the page, page is scrolled.
		 */

        Dimension size = driver.manage().window().getSize();
        this.xPath = xpath;
        boolean find = false;
        int i = 0;

        for (; find == false && i != 5; i++) {

            try {
                element = driver.findElement(By.xpath(xPath));

                if ((element.getLocation().y < size.height * 1.1) & (element.getLocation().y > 2000)) {

                } else {
                    find = true;
                    break;
                }

            } catch (Exception e) {

            }
            int starty = (int) (size.height * 0.80);
            int endy = (int) (size.height * 0.60);
            int startx = size.width / 2;
            driver.swipe(startx, starty, startx, endy, 3000);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean booleanScroll(String xpath) {
		/*
		 * Method verifies if chosen element is present on the page and enabled
		 * for selection. If element does not present on the page, page is
		 * scrolled. If element presents on the page but is enabled for
		 * selection the 'false' will be return. (Example: used for seat
		 * selection)
		 */
        Dimension size = driver.manage().window().getSize();

        this.xPath = xpath;

        for (int i = 0; find == false && i != 5; i++) {

            try {
                element = driver.findElement(By.xpath(xPath));
                element.isEnabled();

                if ((element.getLocation().y < size.height * 1.1) & (element.getLocation().y > 2000)) {
                } else if (element.isEnabled() == false) {
                    find = false;
                    break;
                } else {
                    find = true;
                    break;
                }
            } catch (Exception e) {

            }
            // Find swipe start and end point from screen's with and height.
            // Find starty point which is at bottom side of screen.
            int starty = (int) (size.height * 0.80);
            // Find endy point which is at top side of screen.
            int endy = (int) (size.height * 0.60);
            // Find horizontal point where you wants to swipe. It is in middle
            // of screen width.
            int startx = size.width / 2;

            // Swipe from Top to Bottom
            driver.swipe(startx, starty, startx, endy, 3000);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return find;
    }



}