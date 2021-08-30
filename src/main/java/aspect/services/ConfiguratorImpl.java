package aspect.services;

import aspect.custom_exceptions.DBException;
import org.springframework.stereotype.Service;


@Service
public class ConfiguratorImpl implements Configurator {
    @Override
    public Object configure(Object obj) {
        throw new DBException("Oh, no! DBException!");
    }
}
