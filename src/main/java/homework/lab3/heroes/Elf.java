package homework.lab3.heroes;

import homework.lab3.strategy.KillerStrategy;

public class Elf extends Hero {
    private final static int POWER_ELF = 10;
    private final static int HP_ELF = 10;

    public Elf() {
        this.power = POWER_ELF;
        this.hp = HP_ELF;
        this.strategy = new KillerStrategy();
    }
}
