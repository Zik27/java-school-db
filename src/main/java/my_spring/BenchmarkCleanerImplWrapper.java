package my_spring;

import my_spring.annotations.InjectByType;
import my_spring.cleaner.Cleaner;
import my_spring.cleaner.CleanerImpl;

/**
 * @author Evgeny Borisov
 */
public class BenchmarkCleanerImplWrapper implements Cleaner { //or extends CleanerImpl

    @InjectByType
    private CleanerImpl cleaner;

    @Override
    public void clean() {
        long start = System.nanoTime();
        cleaner.clean();
        long end = System.nanoTime();
        System.out.println(end-start);
    }

    public void test() {
        System.out.println("TEST");
    }
}
