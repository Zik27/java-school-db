package streams;

import streams.lab.Seniority;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class EmployeeUtils {
    public static int sumOfSalaries(List<Employee> list) {
        return list.stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public static List<String> sortBySalaries(List<Employee> list) {
        return list.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, Employee> getUniqueEmplSortedBySalary(List<Employee> list) {
        return list.stream()
                .collect(toMap(Employee::getName, Function.identity(), (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2));
    }

    public static Map<Seniority, Long> groupBySeniority(List<Employee> list) {
        return list.stream()
                .map(Employee::getSalary)
                .collect(groupingBy(Seniority::getDegreeBySalary, Collectors.counting()));
    }

    public static void main(String[] args) {
        List<Employee> list = List.of(
                new Employee("Andrew", 5000),
                new Employee("Petya",10),
                new Employee("Katya", 100),
                new Employee("Andrew", 1),
                new Employee("Andrew", 12)
        );

        System.out.println(groupBySeniority(list));
    }
}
