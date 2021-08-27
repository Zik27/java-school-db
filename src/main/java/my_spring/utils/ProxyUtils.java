package my_spring.utils;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyUtils {
    private static final Enhancer enhancer = new Enhancer();

    public static <T> T createProxyByInterface(T obj, InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }

    public static <T> T createProxyByClass(T obj, MethodInterceptor methodInterceptor) {
        return (T) enhancer.create(obj.getClass(), methodInterceptor);
    }

    public static <T> boolean hasInterfaces(Class<T> type) {
        return type.getInterfaces().length != 0;
    }
}
