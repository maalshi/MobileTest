package pageobject;

import businessobject.dates.BookingDate;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class SwipeSelectDatePage extends AbstractPage  {

    private AndroidDriver driver;
    private String day;
    private String month;
    private String year;
    private String dayXPath;

    public String createDayXpath(BookingDate bookingDate) {
        day = bookingDate.getDay();
        month = bookingDate.getMonth();
        year = bookingDate.getYear();

        dayXPath = "//android.widget.TextView[@text = '" + month + " " + year
                + "']/..//android.widget.TextView[@text = '" + day + "']";

        return dayXPath;
    }

    public void swipeDownToFindDay(AndroidDriver driver, BookingDate bookingDate) {

        Dimension size = driver.manage().window().getSize();

        boolean find = false;
        int i = 0;

        for (; find == false && i != 5; i++) {

            try {
                String dayXPath = createDayXpath(bookingDate);
                AndroidElement selectedDay;
                selectedDay = (AndroidElement) driver.findElement(By.xpath(dayXPath));
                waitElement(selectedDay);
                System.out.println(i);
                System.out.println("day is found" + selectedDay.getLocation().y + " " + size.height * 1.1 + " "
                        + size.height * 0.1);

                if ((selectedDay.getLocation().y < size.height * 1.1) & (selectedDay.getLocation().y > 2000)) {
                    System.out.println(dayXPath);
                    System.out.println("if");

                } else {
                    System.out.println("else");
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
            System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

            // Swipe from Top to Bottom
            driver.swipe(startx, starty, startx, endy, 3000);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Button 'Flight From' has been found");
    }
}

