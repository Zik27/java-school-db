package my_spring;

import lombok.Getter;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//1. Refactor the code, extract proxy benchmark logic from ObjectFactory
//2. Add additional support for @Benchmark annotation, method marked with @Benchmark should be benchmarked and other not
//3. Write support for proxy classes, which doesn't have any interfaces   (use CGLIB)

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    @Getter
    private static final ObjectFactory instance = new ObjectFactory();
    private final Config config = new JavaConfig();
    private final Reflections scanner = new Reflections("my_spring");
    private final List<ObjectConfigurator> configurators = new ArrayList<>();
    private final ProxyConfiguratorService proxyConfigurator = new ProxyConfiguratorService();

    @SneakyThrows
    public ObjectFactory() {
        for (var configurator : scanner.getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(configurator.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    private <T> void configure(T obj) {
        configurators.forEach(conf -> conf.configure(obj));
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
    private <T> void runInit(T obj) {
        for (Method declaredMethod : obj.getClass().getDeclaredMethods()) {
            if (declaredMethod.getName().startsWith("init") && declaredMethod.getParameterCount() == 0) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(obj);
            }
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = resolveImple(type);
        T t = type.getDeclaredConstructor().newInstance();
        configure(t);
        runInit(t);
        return proxyConfigurator.configureAllProxy(t);
    }
}
