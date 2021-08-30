package aspect.custom_exceptions.handlers;

import aspect.custom_exceptions.DBException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DBExceptionHandlerImpl implements DBExceptionHandler {
    private List<String> mails;

    @Value("${mails}")
    private void setMails(String[] mails) {
        this.mails = Arrays.asList(mails);
    }

    @Override
    public void handle(DBException exception) {
        System.out.println("Sending mails...");
        mails.forEach(mail -> System.out.println("Email: " + mail +
                "\nMessage: " + exception.getMessage() +
                "\nStack trace:" + Arrays.toString(Thread.currentThread().getStackTrace())));
    }
}
