package homework.lab5.services.sender;

import homework.lab5.model.MailInfo;
import homework.lab5.services.MailSenderService;

public class WelcomeMailSender implements MailSenderService {
    @Override
    public void send(MailInfo mailInfo) {
        System.out.println("Welcome mail was sent "+ mailInfo.getContext());
    }
}
