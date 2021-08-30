package aspect;

import aspect.custom_exceptions.DBException;
import aspect.services.Creator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class MainScheduledWorker {

    @Autowired
    private Creator creator;


    @Scheduled(fixedDelay = 20000)
    public void doWork() {
        try {
            creator.create();
        } catch (Exception e) {
            System.out.println("У нас проблемы... База перегружается");
        }
    }
}
