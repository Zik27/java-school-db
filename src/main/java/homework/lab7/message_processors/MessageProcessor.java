package homework.lab7.message_processors;

import homework.lab7.Message;

public interface MessageProcessor {
    void execute(Message message);
}
