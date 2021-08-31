package aspect.custom_exceptions;

import aspect.custom_exceptions.handlers.DBExceptionHandler;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class ExceptionHandlerAspect {
    private static boolean isHandled;

    @Autowired
    private DBExceptionHandler dbExceptionHandler;

    @SneakyThrows
    @Around("execution(* aspect.services..*.*(..))")
    public Object handleDBException(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (DBException exception) {
            if (!isHandled) {
                dbExceptionHandler.handle(exception);
                isHandled = true;
            }
            throw new DBException(exception.getMessage(),exception);
        }
    }

//    @SneakyThrows
//    @AfterThrowing(pointcut = "execution(* aspect.services..*.*(..))", throwing = "ex")
//    public void handleDBException(ProceedingJoinPoint pjp, DBException ex) {
//            dbExceptionHandler.handle(ex);
//    }
}
