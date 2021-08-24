package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                .collect(toMap(Employee::getName, empl -> empl, (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2));
    }

    public static void main(String[] args) {
        List<Employee> list = List.of(
                new Employee("Andrew", 5000),
                new Employee("Petya",10),
                new Employee("Katya", 100),
                new Employee("Andrew", 10)
        );

        System.out.println(sortBySalaries(list));
        System.out.println(getUniqueEmplSortedBySalary(list));
    }
}
