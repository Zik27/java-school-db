package homework.lab2;

public class Main {
    public static void main(String[] args) {
        Client client = new Client.ClientBuilder()
                .debt(10)
                .bonus(100)
                .name("Eva")
                .salary(400)
                .build();
        System.out.println(client);
    }
}

