package spring.speakers;

import spring.speakers.Speaker;

public class ConsoleSpeaker implements Speaker {
    @Override
    public void speak() {
        System.out.println("I'M A CONSOLE SPEAKER!!1");
    }
}
