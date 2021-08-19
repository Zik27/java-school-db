package homework.lab3.factories;

import homework.lab3.factories.HeroFactory;
import homework.lab3.heroes.Hero;

import java.util.Random;

public class RandomHeroFactory implements HeroFactory {
    public Hero createHero() {
        int randomNumber = new Random().nextInt(typesOfHeroes.values().length);
        return typesOfHeroes.values()[randomNumber].create();
    }
}
