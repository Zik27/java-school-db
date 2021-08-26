package my_spring;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static my_spring.AnnotationsUtils.isAnnotated;

@AllArgsConstructor
public class BenchmarkInvocationHandler<T> implements InvocationHandler {
    private final T obj;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (isAnnotated(obj.getClass(), Benchmark.class, method)) {
            System.out.println("********BENCHMARK STARTED FOR METHOD " + method.getName() + " **********");
            long start = System.nanoTime();
            Object retVal = method.invoke(obj, args);
            long end = System.nanoTime();
            System.out.println("Time spent on execution: " + (end - start) + " ns");
            System.out.println("********BENCHMARK ENDED FOR METHOD " + method.getName() + " **********");
            return retVal;
        }
        return method.invoke(obj, args);
    }
}
