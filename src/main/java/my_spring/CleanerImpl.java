package my_spring;

import java.util.stream.IntStream;

/**
 * @author Evgeny Borisov
 */
public class CleanerImpl implements Cleaner {
    @InjectRandomInt(min = 3, max = 5)
    private int repeat;

    @Override
    public void clean() {
        IntStream.range(0, repeat)
                .mapToObj(i -> "VVVVVVVvvvvvvvvvvvvvvvvv")
                .forEach(System.out::println);
    }
}
