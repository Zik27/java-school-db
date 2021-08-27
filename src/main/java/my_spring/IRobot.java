package my_spring;


import my_spring.annotations.InjectByType;
import my_spring.cleaner.Cleaner;
import my_spring.cleaner.CleanerImpl;
import my_spring.speaker.Speaker;

/**
 * @author Evgeny Borisov
 */
public class IRobot {
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void cleanRoom() {
        speaker.speak("Я начал работать");
        cleaner.clean();
        cleaner.test();
        speaker.speak("Я закончил работать");
    }
}
