package my_spring.speaker;


import my_spring.speaker.Speaker;

/**
 * @author Evgeny Borisov
 */
public class ConsoleSpeaker implements Speaker {
    private int volume;
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
