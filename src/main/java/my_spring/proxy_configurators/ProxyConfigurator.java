package my_spring.proxy_configurators;

public interface ProxyConfigurator {
    <T> T configure(T obj, Class<?> type);
}
