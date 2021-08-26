package my_spring;

public class CleanerImplProxy implements Cleaner {
    private final Cleaner cleaner = ObjectFactory.getInstance().createObject(CleanerImpl.class);
    @Override
    public void clean() {
        long start = System.nanoTime();
        cleaner.clean();
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
