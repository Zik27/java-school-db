package spring;

import spring.cleaners.Cleaner;

public class Main {
    public static void main(String[] args) {
        System.out.println(ObjectFactoryImpl.getInstance().createObject(Cleaner.class));
    }
}
