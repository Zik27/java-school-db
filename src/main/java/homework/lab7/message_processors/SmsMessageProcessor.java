package homework.lab7.message_processors;

import homework.lab7.Message;
import org.springframework.stereotype.Component;

@Component("sms")
public class SmsMessageProcessor implements MessageProcessor {
    @Override
    public void execute(Message message) {
        System.out.println("SMS was sent with text: " + message.getContent());
    }
}
