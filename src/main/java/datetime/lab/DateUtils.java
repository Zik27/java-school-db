package datetime.lab;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    // format 01-01-2021 13,55,00
    private static final String pattern = "dd-MM-yyyy hh,mm,ss";

    public static Date convertStringToDate(String date) throws ParseException {
        DateFormat dt = new SimpleDateFormat(pattern);
        return dt.parse(date);
    }

    public static String convertDateToString(Date date) {
        DateFormat dt = new SimpleDateFormat(pattern);
        return dt.format(date);
    }

    public static void main(String[] args) throws ParseException {
        Date dt = new SimpleDateFormat(pattern).getCalendar().getTime();

        System.out.println(convertStringToDate("01-01-2021 13,55,55"));
        System.out.println(convertDateToString(dt));
    }
}
