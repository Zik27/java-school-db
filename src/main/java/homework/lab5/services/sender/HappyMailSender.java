package homework.lab5.services.sender;

import homework.lab5.MailInfo;
import homework.lab5.services.MailSenderService;

public class HappyMailSender implements MailSenderService {
    @Override
    public void send(MailInfo mailInfo) {
        System.out.println("Happy Birthdate mail was sent " + mailInfo.getContext());
    }
}
