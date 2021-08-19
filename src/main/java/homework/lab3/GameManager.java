package homework.lab3;

import homework.lab3.heroes.Hero;

import static homework.lab3.utils.ParamsGenerator.generateRndNumberInRange;

public class GameManager {
    void fight(Hero c1, Hero c2) {
        System.out.println(c1.getName() + " VS " + c2.getName());

        while (c1.isAlive() && c2.isAlive()) {
            if (generateRndNumberInRange(1, 2) == 1) {
                c1.kick(c2);
            } else {
                c2.kick(c1);
            }
        }

        System.out.println(c1.getHp() == 0 ? c2.getName() + " has won the battle"
                : c1.getName() + " has won the battle!");
    }
}
