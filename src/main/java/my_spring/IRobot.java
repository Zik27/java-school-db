package my_spring;


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
