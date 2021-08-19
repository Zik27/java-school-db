package homework.lab3.heroes;

import homework.lab3.strategy.FightStrategy;
import lombok.Getter;

import static homework.lab3.utils.ParamsGenerator.generateRndName;

@Getter
public abstract class Hero {
    private final String name;
    protected int power;
    protected int hp;
    protected FightStrategy strategy;

    public Hero() {
        this.name = this.getClass().getSimpleName() + " " + generateRndName();
    }

    public void kick(Hero enemy) {
        strategy.kick(this, enemy);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void reducePower(int diff) {
        power = diff > power ? 0 : power - diff;
    }

    public void reduceHp(int damage) {
        hp = damage > hp ? 0 : hp - damage;
    }
}
