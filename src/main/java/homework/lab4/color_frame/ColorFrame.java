package homework.lab4.color_frame;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ColorFrame extends JFrame {
    public ColorFrame(final int counter) throws HeadlessException {
        // We can use a mutable wrapper (e.g. AtomicInteger or something like that)
        AtomicInteger trueCounter = new AtomicInteger(counter);

        setSize(500, 500);
        JButton button = new JButton("click me to be red");

        button.addActionListener(e -> System.out.println(trueCounter.incrementAndGet()));

        getContentPane().add(button, BorderLayout.NORTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ColorFrame(10);
    }
}

