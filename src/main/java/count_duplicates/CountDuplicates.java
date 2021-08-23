package count_duplicates;

import java.util.List;

public class CountDuplicates {
    public static <T> int countDuplicates(T obj, List<T> list) {
        return (int) list.stream().filter(obj::equals).count();
    }

    public static void main(String[] args) {
        List<Integer> test = List.of(2, 2, 3, 4);
        System.out.println(countDuplicates(2, test));
    }
}
