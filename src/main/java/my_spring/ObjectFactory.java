package my_spring;

import lombok.Getter;
import lombok.SneakyThrows;
import org.reflections.Reflections;
import java.util.Set;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    @Getter
    private static final ObjectFactory instance = new ObjectFactory();
    private final Config config = new JavaConfig();
    private static final Reflections scanner = new Reflections("my_spring");
    private static final Set<Class<? extends ObjectConfigurator>> injectors = scanner.getSubTypesOf(ObjectConfigurator.class);


    @SneakyThrows
    private <T> void configureObject(T obj) {
        for (var injector : injectors) {
            injector.getDeclaredConstructor().newInstance().configure(obj);
        }
    }

    private <T> Class<T> resolveImple(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more than one impl was found, please update your config");
                }
                implClass = (Class<T>) classes.iterator().next();
            }
            type = implClass;
        }
        return type;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImple(type);
        T t = type.getDeclaredConstructor().newInstance();
        configureObject(t);
        return t;
    }
}
