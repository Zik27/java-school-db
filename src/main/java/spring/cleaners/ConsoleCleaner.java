package spring.cleaners;

import spring.cleaners.Cleaner;

public class ConsoleCleaner implements Cleaner {
    @Override
    public void clean() {
        System.out.println("I'M A CONSOLE CLEANER!!1");
    }
}
