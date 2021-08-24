package streams.lab;

import java.util.Arrays;

public enum Seniority {
    JUN(0, 10),
    MIDDLE(10, 20),
    SENIOR(20, Integer.MAX_VALUE);

    private final int minSalary;
    private final int maxSalary;

    Seniority(int minSalary, int maxSalary) {
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public static Seniority getDegreeBySalary(int salary) {
        return Arrays.stream(values())
                .filter(degree -> degree.minSalary <= salary && degree.maxSalary >= salary)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Invalid salary: %s.", salary)));
    }
}
