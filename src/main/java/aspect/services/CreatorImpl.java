package aspect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreatorImpl implements Creator {

    @Autowired
    private Configurator configurator;

    @Override
    public Object create() {
        return configurator.configure(new Object());
    }
}
