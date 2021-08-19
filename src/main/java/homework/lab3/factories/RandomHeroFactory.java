package homework.lab3.factories;

import homework.lab3.heroes.Hero;

import static homework.lab3.utils.ParamsGenerator.generateRndNumberInRange;

public class RandomHeroFactory implements HeroFactory {
    public Hero createHero() {
        int randomNumber = generateRndNumberInRange(0, TypesOfHeroes.values().length);
        return TypesOfHeroes.values()[randomNumber].create();
    }
}
