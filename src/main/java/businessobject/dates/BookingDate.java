package businessobject.dates;

public class BookingDate {

    private String day;
    private String month;
    private String year;

    public BookingDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public BookingDate() {

    }

    public BookingDate withDay(String day) {
        this.setDay(day);
        return this;
    }

    public BookingDate withMonth(String month) {
        this.setMonth(month);
        return this;
    }

    public BookingDate withYear(String year) {
        this.setYear(year);
        return this;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    @Override

    public String toString() {
        return "Date(" + "day " + day + '\'' + "month " + month + '\'' + "year " + year + '\'' + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        BookingDate bookingDate = (BookingDate) o;

        if (day != null ? !day.equals(bookingDate.day) : bookingDate.day != null)
            return false;
        if (month != null ? !month.equals(bookingDate.month) : bookingDate.month != null)
            return false;
        return !(year != null ? !year.equals(bookingDate.year) : bookingDate.year != null);
    }

    @Override
    public int hashCode() {
        int result = day != null ? day.hashCode() : 0;
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}

