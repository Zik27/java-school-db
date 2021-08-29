package homework.lab7;

import homework.lab7.message_processors.MessageProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @author Evgeny Borisov
 */
@Component
public class MessageDistributor {
    @Autowired
    private Map<String, MessageProcessor> messageProcessor;

    public void distribute(Message message) {
        Optional.ofNullable(messageProcessor.get(message.getChannelName().toLowerCase()))
                .orElseThrow(() -> new IllegalArgumentException("Message processor for channel type [" + message.getChannelName() + "] is not found"))
                .execute(message);
    }
}
