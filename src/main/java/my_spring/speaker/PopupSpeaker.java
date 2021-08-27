package my_spring.speaker;

import my_spring.speaker.Speaker;

import javax.swing.*;

/**
 * @author Evgeny Borisov
 */
public class PopupSpeaker implements Speaker {
    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null,message);
    }
}
