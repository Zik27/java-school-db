package homework.lab3.strategy;

import homework.lab3.heroes.Hero;

public interface FightStrategy {
    void kick(Hero mainHero, Hero enemy);
}
