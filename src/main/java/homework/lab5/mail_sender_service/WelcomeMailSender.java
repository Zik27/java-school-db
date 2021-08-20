package homework.lab5.mail_sender_service;

import homework.lab5.MailInfo;

public class WelcomeMailSender implements MailSenderService {
    @Override
    public void send(MailInfo mailInfo) {
        System.out.println("Welcome mail was sent "+ mailInfo.getContext());
    }
}
