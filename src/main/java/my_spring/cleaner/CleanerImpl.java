package my_spring.cleaner;

import my_spring.annotations.Benchmark;
import my_spring.annotations.InjectRandomInt;

import java.util.stream.IntStream;

/**
 * @author Evgeny Borisov
 */

public class CleanerImpl implements Cleaner{
    @InjectRandomInt(min = 3, max = 5)
    private int repeat;

    @Benchmark
    public void clean() {
        IntStream.range(0, repeat)
                .mapToObj(i -> "VVVVVVVvvvvvvvvvvvvvvvvv")
                .forEach(System.out::println);
    }

    public void test() {
        IntStream.range(0, repeat)
                .mapToObj(i -> "TEST")
                .forEach(System.out::println);
    }
}
