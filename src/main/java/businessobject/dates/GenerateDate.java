package businessobject.dates;

import java.util.Calendar;

public class GenerateDate {

    private String dafaultNextMonth;
    private String dafaultCurrentYear;
    private String dafaultday;

    private String nextMonth() {

        Calendar cal = Calendar.getInstance();
        int nextMonthValue;

        nextMonthValue = cal.get(Calendar.MONTH) + 1;

        String currentDateFromInt = null;

        switch (nextMonthValue) {
            case 0:
                currentDateFromInt = "January";
                break;
            case 1:
                currentDateFromInt = "February";
                break;
            case 2:
                currentDateFromInt = "March";
                break;
            case 3:
                currentDateFromInt = "April";
                break;
            case 4:
                currentDateFromInt = "May";
                break;
            case 5:
                currentDateFromInt = "June";
                break;
            case 6:
                currentDateFromInt = "Junly";
                break;
            case 7:
                currentDateFromInt = "August";
                break;
            case 8:
                currentDateFromInt = "September";
                break;
            case 9:
                currentDateFromInt = "October";
                break;
            case 10:
                currentDateFromInt = "November";
                break;
            case 11:
                currentDateFromInt = "December";
                break;
        }

        dafaultNextMonth = currentDateFromInt;

        return currentDateFromInt;

    }

    private String currentYear() {
        int currentYear;
        Calendar cal = Calendar.getInstance();

        currentYear = cal.get(Calendar.YEAR);
        dafaultCurrentYear = Integer.toString(currentYear);

        return dafaultCurrentYear;

    }

    public void setDefaultDate() {
        nextMonth();
        currentYear();
    }

    public String getNextMonth() {
        return dafaultNextMonth;
    }

    public String getCurrentYear() {
        return dafaultCurrentYear;
    }

}

