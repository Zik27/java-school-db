package my_spring;

import homework.lab3.utils.ParamsGenerator;
import lombok.Getter;
import lombok.SneakyThrows;
import my_spring.annotations.InjectByType;
import my_spring.annotations.InjectRandomInt;
import my_spring.injector_handlers.InjectorByTypeHandler;
import my_spring.injector_handlers.InjectorRandomIntHandler;
import my_spring.injector_handlers.Injectors;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    @Getter
    private final static ObjectFactory instance = new ObjectFactory();
    private final Config config = new JavaConfig();
    private final static Map <Class<?>, Injectors> annotations = Map.of(
            InjectRandomInt.class, new InjectorRandomIntHandler(),
            InjectByType.class, new InjectorByTypeHandler());

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }

        T t = type.getDeclaredConstructor().newInstance();

        for (Field declaredField : t.getClass().getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = declaredField.getAnnotation(InjectRandomInt.class);
                declaredField.setAccessible(true);
                declaredField.setInt(t, ParamsGenerator.generateRndNumberInRange(annotation.min(), annotation.max()));
                declaredField.setAccessible(false);
            }
            if (declaredField.isAnnotationPresent(InjectByType.class)) {
                declaredField.setAccessible(true);
                declaredField.set(t, instance.createObject(declaredField.getType()));
                declaredField.setAccessible(false);
            }
        }
        return t;
    }
}
