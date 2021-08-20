package homework.lab6;

import homework.lab6.models.*;

public class RadioAlarm implements Radio, Alarm {
    @Override
    public void a() {
        System.out.println("It's A");
    }

    @Override
    public void b() {
        System.out.println("It's B");
    }
    @Override
    public void c() {
        System.out.println("It's C");
    }
    @Override
    public void d() {
        System.out.println("It's D");
    }
}
