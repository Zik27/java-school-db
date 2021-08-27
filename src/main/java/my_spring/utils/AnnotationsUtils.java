package my_spring.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationsUtils {

    public static boolean hasAnnotatedMethodsInClass(Class<?> type, Class<? extends Annotation> annotation) {
        return Arrays.stream(type.getDeclaredMethods())
                .anyMatch(method -> method.isAnnotationPresent(annotation));
    }

    public static boolean hasAnnotation(Class<?> type, Class<? extends Annotation> annotation, Method calledMethod) {
        return type.isAnnotationPresent(annotation) ||
                Arrays.stream(type.getDeclaredMethods())
                        .anyMatch(m -> m.isAnnotationPresent(annotation) && m.getName().equals(calledMethod.getName()));
    }
}
