package homework.lab5.mail_sender_service;

import homework.lab5.MailInfo;

public class HappyMailSender implements MailSenderService {
    @Override
    public void send(MailInfo mailInfo) {
        System.out.println("Happy Birthdate mail was sent " + mailInfo.getContext());
    }
}
