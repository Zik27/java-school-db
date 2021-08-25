package spring;

import lombok.SneakyThrows;
import spring.cleaners.Cleaner;
import spring.cleaners.ConsoleCleaner;
import spring.speakers.ConsoleSpeaker;
import spring.speakers.Speaker;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ObjectFactoryImpl implements ObjectFactory {
    private static final ObjectFactory instance = new ObjectFactoryImpl();
    private final static Map<Class<?>, Class<?>> interfaceMap = new HashMap<>();

    static {
        interfaceMap.put(Speaker.class, ConsoleSpeaker.class);
        interfaceMap.put(Cleaner.class, ConsoleCleaner.class);
    }

    @SneakyThrows
    @Override
    public Object createObject(Class<?> type) {
        Class<?> objectClass = !type.isInterface() ? type :  Optional.ofNullable(interfaceMap.get(type))
                .orElseThrow(() -> new IllegalArgumentException("Interface type [" + type.getSimpleName() + "] is not found"));
        return objectClass.getDeclaredConstructor().newInstance();
    }

    public static ObjectFactory getInstance() {
        return instance;
    }
}
