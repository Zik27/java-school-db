package aspect.custom_exceptions;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class DBExceptionHandlerAspect {

    private List<String> mails;

    @Value("${mails}")
    private void setMails(String[] mails) {
        this.mails = Arrays.asList(mails);
    }

    private void sendExceptionToMail(Throwable exception) {
        mails.forEach(mail -> System.out.println("Email: " + mail +
                "\nMessage: " + exception.getMessage() +
                "\nStack trace:" + Arrays.toString(Thread.currentThread().getStackTrace())));
    }

    @SneakyThrows
    @Around("execution(* aspect..*.doWork*(..))")
    public Object handleDBException(ProceedingJoinPoint pjp) {
        Object retVal = null;

        try {
            retVal = pjp.proceed();
        } catch (DBException exception) {
            sendExceptionToMail(exception);
        }
        return retVal;
    }
}
