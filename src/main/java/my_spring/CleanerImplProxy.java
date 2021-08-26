package my_spring;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CleanerImplProxy implements Cleaner {
    private final CleanerImpl cleaner;

    @Override
    public void clean() {
        long start = System.nanoTime();
        cleaner.clean();
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
