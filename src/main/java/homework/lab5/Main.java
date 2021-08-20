package homework.lab5;

import com.github.javafaker.Faker;
import homework.lab3.utils.ParamsGenerator;
import homework.lab5.services.inf.MailSenderFactory;
import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        MailSenderFactory mailSender = new MailSenderFactory();
        Faker faker = new Faker();
        while (true) {
            MailInfo mailInfo = MailInfo.builder()
                    .context(faker.chuckNorris().fact())
                    .mailType(ParamsGenerator.generateRndNumberInRange(1, 2))
                    .build();

            mailSender.send(mailInfo);
            Thread.sleep(2000);
        }
    }
}

