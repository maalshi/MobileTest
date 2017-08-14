package businessobject.dates;

public class DefaultDate {

    public static BookingDate CreateDefaultDate() {
        BookingDate bookingDate = new BookingDate();
        GenerateDate denerateDate = new GenerateDate();
        denerateDate.setDefaultDate();
        bookingDate.setDay("1");
        bookingDate.setMonth(denerateDate.getNextMonth());
        bookingDate.setYear(denerateDate.getCurrentYear());
        return bookingDate;
    }

}
