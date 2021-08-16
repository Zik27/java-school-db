package homework.lab1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SuperIntegerListImpl implements SuperIntegerList {
    private int[] array;

    public SuperIntegerListImpl(int[] array) {
        this.array = array;
    }

    @Override
    public void add(int number) {
        int[] newArray = new int[array.length + 1];

        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = number;
        array = newArray;
    }

    @Override
    public void removeByIndex(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        array = IntStream.range(0, array.length)
                .filter(i -> i != index)
                .map(idx -> array[idx])
                .toArray();
    }

    @Override
    public void removeByValue(int value) {
        array = Arrays.stream(array)
                .filter(i -> i != value)
                .toArray();
    }

    @Override
    public int get(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public void printAll() {
        System.out.println(Arrays.toString(array));
    }
}
