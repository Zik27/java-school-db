package my_spring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class JavaConfig implements Config {

    private Map<Class, Class> ifc2ImplClass = new HashMap<>();
    private Map<Class, Class> implClass2proxy = new HashMap<>();

    public JavaConfig() {
        ifc2ImplClass.put(Speaker.class, ConsoleSpeaker.class);
        ifc2ImplClass.put(Cleaner.class, CleanerImpl.class);

        implClass2proxy.put(CleanerImpl.class, CleanerImplProxy.class);
    }

    @Override
    public <T> Class<T> getImplClass(Class<T> type) {
        return ifc2ImplClass.get(type);
    }

    @Override
    public <T> Class<T> getProxyClass(Class<T> type) {
        return implClass2proxy.get(type);
    }
}





