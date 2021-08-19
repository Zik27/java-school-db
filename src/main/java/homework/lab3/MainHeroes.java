package homework.lab3;

import homework.lab3.factories.HeroFactory;
import homework.lab3.factories.RandomHeroFactory;
import homework.lab3.heroes.Hero;

public class MainHeroes {
    public static void main(String[] args) {
        HeroFactory heroFactory = new RandomHeroFactory();
        Hero hero1 = heroFactory.createHero();
        Hero hero2 = heroFactory.createHero();

        GameManager gameManager = new GameManager();
        gameManager.fight(hero1, hero2);
    }
}
