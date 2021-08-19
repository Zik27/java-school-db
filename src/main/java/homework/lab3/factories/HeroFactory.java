package homework.lab3.factories;

import homework.lab3.heroes.*;

public interface HeroFactory {
    enum typesOfHeroes {
        Hobbit {
            public Hero create() {
                return new Hobbit();
            }
        },
        Elf {
            public Hero create() {
                return new Elf();
            }
        },
        King {
            public Hero create() {
                return new King();
            }
        },
        Knight {
            public Hero create() {
                return new Knight();
            }
        };

        public abstract Hero create();
    }

    Hero createHero();
}
