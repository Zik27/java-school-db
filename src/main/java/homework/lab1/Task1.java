package homework.lab1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        double[] arrayOfDoubles = {2.0, 3.0, -4.0, 0.0, 20.0};
        int[] arrayOfInts = new int[arrayOfDoubles.length];

        for (int i = 0; i < arrayOfDoubles.length; i++) {
            arrayOfInts[i] = (int) arrayOfDoubles[i];
        }

        System.out.println("Initial array: " + Arrays.toString(arrayOfDoubles) +
                        "\nResulting array: " + Arrays.toString(arrayOfInts));
    }
}
