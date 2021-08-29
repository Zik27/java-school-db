package homework.lab7.message_processors;

import homework.lab7.Message;
import org.springframework.stereotype.Component;

@Component("telegram")
public class TelegramMessageProcessor implements MessageProcessor {
    @Override
    public void execute(Message message) {
        System.out.println("Telegram was sent with text: " + message.getContent());
    }
}
