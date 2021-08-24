package streams;

import java.util.List;

public class EmployeeUtils {
    public static int sumOfSalaries(List<Employee> list) {
        return list.stream().mapToInt(Employee::getSalary).sum();
    }

    public static void main(String[] args) {
        List<Employee> list = List.of(new Employee(5000), new Employee(10), new Employee(100));
        System.out.println(sumOfSalaries(list));
    }
}
