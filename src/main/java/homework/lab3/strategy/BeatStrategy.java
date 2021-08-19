package homework.lab3.strategy;

import homework.lab3.heroes.Hero;

public class BeatStrategy implements FightStrategy{
    @Override
    public void kick(Hero mainHero, Hero enemy) {
        enemy.reduceHp(mainHero.getPower());
        printKick(mainHero, enemy);
    }

    private void printKick(Hero mainHero, Hero enemy) {
        System.out.println(enemy.getHp() == 0 ? mainHero.getName() + " killed " + enemy.getName() :
                mainHero.getName() + " kicked " + enemy.getName() + " on " + mainHero.getPower() + " HP");
    }
}
