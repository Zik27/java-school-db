package my_spring;

import lombok.Getter;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyService {
    @Getter
    private static final ProxyService instance = new ProxyService();

    public <T> T configureProxy(T obj) {
        if (obj.getClass().isAnnotationPresent(Benchmark.class) || Arrays.stream(obj.getClass().getDeclaredMethods()).anyMatch(method -> method.isAnnotationPresent(Benchmark.class))) {
            return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new BenchmarkInvocationHandler<T>(obj));
        }
        return obj;
    }
}
