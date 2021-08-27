package my_spring.cleaner;


import my_spring.annotations.InjectByType;
import my_spring.cleaner.Cleaner;
import my_spring.cleaner.CleanerImpl;

public class CleanerImplProxy implements Cleaner {
    @InjectByType
    private CleanerImpl cleaner;

    @Override
    public void clean() {
        long start = System.nanoTime();
        cleaner.clean();
        long end = System.nanoTime();
        System.out.println(end - start);
    }

    @Override
    public void test() {
        System.out.println("TEST");
    }
}
