package homework.lab3.utils;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Random;

public class ParamsGenerator {
    private static final Random GEN = new Random();
    private static final Faker GEN_NAME = new Faker();

    public static int generateRndNumberInRange(int min, int max) {
        return GEN.nextInt(max - min + 1) + min;
    }

    public static String generateRndName() {
        return GEN_NAME.name().name();
    }

    public static <T> T getRandomElement(List<T> list) {
        int i = generateRndNumberInRange(0, list.size()-1);
        return list.get(i);
    }
}
