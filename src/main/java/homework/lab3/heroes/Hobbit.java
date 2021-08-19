package homework.lab3.heroes;

public class Hobbit extends Hero {
    private final static int POWER_HOBBIT = 0;
    private final static int HP_HOBBIT = 3;

    public Hobbit() {
        this.power = POWER_HOBBIT;
        this.hp = HP_HOBBIT;
    }

    @Override
    public void kick(Hero c) {
        crying();
    }

    private void crying() {
        System.out.println(this.getName() + " is a little hobbit who can't fight! =(");
    }
}
