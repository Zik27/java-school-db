package my_spring;

import java.util.stream.IntStream;

/**
 * @author Evgeny Borisov
 */
public class CleanerImpl implements Cleaner {
    @InjectRandomInt(min = 3, max = 5)
    private int repeat;

    @Override
    @Benchmark
    public void clean() {
        IntStream.range(0, repeat)
                .mapToObj(i -> "VVVVVVVvvvvvvvvvvvvvvvvv")
                .forEach(System.out::println);
    }

    @Override
    public void test() {
        IntStream.range(0, repeat)
                .mapToObj(i -> "TEST")
                .forEach(System.out::println);
    }
}
