package my_spring;

import lombok.SneakyThrows;
import my_spring.proxy_configurators.ProxyConfigurator;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.*;

public class ProxyConfiguratorService {
    private final Reflections scanner = new Reflections("my_spring.proxy_configurators");
    private final List<ProxyConfigurator> proxyAnnotationConfigurators = new ArrayList<>();

    @SneakyThrows
    public ProxyConfiguratorService() {
        for (var handler : scanner.getSubTypesOf(ProxyConfigurator.class)) {
            if (!Modifier.isAbstract(handler.getModifiers())) {
                proxyAnnotationConfigurators.add(handler.getDeclaredConstructor().newInstance());
            }
        }
    }

    public <T> T configureAllProxy(T t) {
        for (ProxyConfigurator configurator: proxyAnnotationConfigurators) {
            t = configurator.configure(t, t.getClass());
        }
        return t;
    }
}
