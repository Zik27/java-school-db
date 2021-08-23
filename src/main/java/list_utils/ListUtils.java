package list_utils;

import java.util.List;
import java.util.function.Consumer;


public class ListUtils {
    public static <T> long countDuplicates(T obj, List<T> list) {
        return list.stream().filter(obj::equals).count();
    }

    public static <T> void forEachWithDelay(List<T> list, int delay, Consumer<T> consumer) {
        list.forEach(element -> {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            consumer.accept(element);
        });
    }

    public static void main(String[] args) {
        List<Integer> test = List.of(2, 2, 3, 4);
        forEachWithDelay(test, 1000, System.out::println);
    }
}
