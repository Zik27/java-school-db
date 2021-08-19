package homework.lab3.heroes;

import homework.lab3.strategy.BeatStrategy;

import static homework.lab3.utils.ParamsGenerator.generateRndNumberInRange;

public class Knight extends Hero {
    private final static int MIN_POWER = 2;
    private final static int MAX_POWER = 12;

    private final static int MIN_HP = 2;
    private final static int MAX_HP = 12;

    public Knight() {
        this.power = generateRndNumberInRange(MIN_POWER, MAX_POWER);
        this.hp = generateRndNumberInRange(MIN_HP, MAX_HP);
        this.strategy = new BeatStrategy();
    }
}
