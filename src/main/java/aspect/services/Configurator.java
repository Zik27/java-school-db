package aspect.services;

import java.io.IOException;

public interface Configurator {
    Object configure(Object obj) throws IOException;
}
