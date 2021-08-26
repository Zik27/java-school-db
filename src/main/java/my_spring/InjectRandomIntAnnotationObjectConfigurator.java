package my_spring;

import homework.lab3.utils.ParamsGenerator;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class InjectRandomIntAnnotationObjectConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                field.setAccessible(true);
                field.set(t, ParamsGenerator.generateRndNumberInRange(annotation.min(), annotation.max()));
            }
        }
    }
}
