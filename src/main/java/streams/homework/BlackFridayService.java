package streams.homework;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


public class BlackFridayService {
    public void printBlackFridayPerYearSorted(int startYear, int endYear) {
        Stream.iterate(LocalDate.of(startYear, 1, 13),
                date -> date.getYear() <= endYear, date -> date.plusMonths(1))
                .filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY)
                .collect(groupingBy(LocalDate::getYear, counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        BlackFridayService bf = new BlackFridayService();
        bf.printBlackFridayPerYearSorted(1950, 2013);
    }
}
