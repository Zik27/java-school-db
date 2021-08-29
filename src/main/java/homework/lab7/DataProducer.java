package homework.lab7;

import com.github.javafaker.Faker;
import homework.lab3.utils.ParamsGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Component
public class DataProducer {
    private static List<String> channels;

    @Value("${channels}")
    private void setChannels(String[] channels) {
        DataProducer.channels = Arrays.asList(channels);
    }

    public static Message generateMessage() {
        return Message.builder()
                .channelName(ParamsGenerator.getRandomElement(channels))
                .content(Faker.instance().chuckNorris().fact())
                .build();
    }
}
