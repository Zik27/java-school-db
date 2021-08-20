package homework.lab6;

import homework.lab6.models.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RadioAlarmImpl implements RadioAlarm {
    private final Radio radio;
    private final Alarm alarm;

    @Override
    public void a() {
        alarm.a();
    }

    @Override
    public void b() {
        alarm.b();
    }
    @Override
    public void c() {
        radio.c();
    }
    @Override
    public void d() {
        radio.c();
    }
}
