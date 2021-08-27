package my_spring.proxy_configurators;

import my_spring.annotations.Benchmark;
import my_spring.proxy_configurators.handlers.BenchmarkInvocationHandler;


import static my_spring.utils.AnnotationsUtils.hasAnnotatedMethodsInClass;
import static my_spring.utils.ProxyUtils.*;

public class BenchmarkProxyConfigurator implements ProxyConfigurator {

    @Override
    public <T> T configure(T obj, Class<?> type) {

        if (type.isAnnotationPresent(Benchmark.class) || hasAnnotatedMethodsInClass(type, Benchmark.class)) {
            return hasInterfaces(type) ? createProxyByInterface(obj, new BenchmarkInvocationHandler<T>(obj)) :
                    createProxyByClass(obj, (o, method, objects, methodProxy) -> new BenchmarkInvocationHandler<T>(obj).invoke(o, method, objects));
        }
        return obj;
    }
}
