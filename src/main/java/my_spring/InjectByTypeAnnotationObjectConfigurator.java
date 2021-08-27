package my_spring;

import lombok.SneakyThrows;
import my_spring.annotations.InjectByType;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {
    @SneakyThrows
    @Override
    public void configure(Object t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            InjectByType annotation = field.getAnnotation(InjectByType.class);
            if (annotation != null) {
                field.setAccessible(true);
                field.set(t, ObjectFactory.getInstance().createObject(field.getType()));
            }
        }
    }
}
