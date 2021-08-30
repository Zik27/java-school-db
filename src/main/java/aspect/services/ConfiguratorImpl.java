package aspect.services;

import aspect.custom_exceptions.DBException;
import homework.lab3.utils.ParamsGenerator;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConfiguratorImpl implements Configurator {

    public Object configure(Object obj) throws IOException {
        int rndNumb = ParamsGenerator.generateRndNumberInRange(1, 8);

        if (rndNumb % 2 == 0) {
            throw new IOException();
        } else if (rndNumb == 5) {
            throw new DBException("Oh, no! DBException!");
        }
        else {
            System.out.println("Everything all right");
        }
        return obj;
    }
}
