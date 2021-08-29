package homework.lab7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);

        MessageDistributor distributor = context.getBean(MessageDistributor.class);
        DataProducer producer = context.getBean(DataProducer.class);

        while (true) {
            Message message = producer.generateMessage();
            distributor.distribute(message);
            Thread.sleep(2000);
        }
    }
}
