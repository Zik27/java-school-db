package aspect;

import aspect.services.CreatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainScheduledWorker {

    @Autowired
    private CreatorImpl creator;


    @Scheduled(fixedDelay = 2000)
    public void doWork() {
        try {
            creator.create();
        } catch (IOException e) {
            System.err.println("IOException!");
        }
    }
}
