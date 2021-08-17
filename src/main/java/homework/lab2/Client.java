package homework.lab2;

import lombok.ToString;

@ToString
public class Client {
    private final int debt; //todo you can't remove final
    private final int bonus;
    private final String name;
    private final int salary;

    private Client(ClientBuilder builder) {
        debt = builder.debt;
        bonus = builder.bonus;
        name = builder.name;
        salary = builder.salary;
    }

    public static class ClientBuilder {
        private int debt;
        private int bonus;
        private String name;
        private int salary;

        public ClientBuilder debt(int debt) {
            this.debt = debt;
            return this;
        }

        public ClientBuilder bonus(int bonus) {
            this.bonus = bonus;
            return this;
        }

        public ClientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder salary(int salary) {
            this.salary = salary;
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }
}
