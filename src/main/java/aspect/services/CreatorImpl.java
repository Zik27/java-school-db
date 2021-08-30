package aspect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CreatorImpl implements Creator {

    @Autowired
    private ConfiguratorImpl configurator;

    public Object create() throws IOException {
        return configurator.configure(new Object());
    }
}
