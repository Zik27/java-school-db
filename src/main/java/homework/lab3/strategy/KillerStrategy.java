package homework.lab3.strategy;

import homework.lab3.heroes.Hero;

public class KillerStrategy implements FightStrategy {
    public static final int COUNT_DECREASE_POWER = 1;

    @Override
    public void kick(Hero mainHero, Hero enemy) {
        if (mainHero.getPower() > enemy.getPower()) {
            enemy.reduceHp(enemy.getHp());
        } else {
            enemy.reducePower(COUNT_DECREASE_POWER);
        }
        printKick(mainHero, enemy);
    }

    private void printKick(Hero mainHero, Hero enemy) {
        System.out.println(enemy.getHp() == 0 ? mainHero.getName() + " killed " + enemy.getName() :
                mainHero.getName() + " decreased power " + enemy.getName() + " on " + COUNT_DECREASE_POWER);
    }
}
