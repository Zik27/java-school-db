package homework.lab5.mail_sender_service;

import homework.lab5.MailInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MailSenderFactory {
    private final static Map<Integer, MailSenderService> mailMap = new HashMap<>();

    static {
        mailMap.put(1, new WelcomeMailSender());
        mailMap.put(2, new HappyMailSender());
    }

    private static MailSenderService getMailSender(Integer mailType) {
        return Optional.ofNullable(mailMap.get(mailType))
                .orElseThrow(() -> new IllegalArgumentException("Mail type [" + mailType +"] is not found"));
    }

    public void send(MailInfo mailInfo) {
        getMailSender(mailInfo.getMailType()).send(mailInfo);
    }
}

