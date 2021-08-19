package homework.lab4.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd$MM$yyyy HH,mm,ss");

    public static LocalDateTime convertStringToDate(String date) {
        return LocalDateTime.from(formatter.parse(date));
    }

    public static String convertDateToString(LocalDateTime date) {
        return date.format(formatter);
    }

    public static void main(String[] args) {
        System.out.println(convertStringToDate("01$01$2021 13,55,55"));
        System.out.println(convertDateToString(LocalDateTime.now()));

        System.out.println(convertStringToDate("01$01$1996 00,00,01"));
        System.out.println(convertDateToString(LocalDateTime.of(2021, 11, 1, 12, 20)));
    }
}
