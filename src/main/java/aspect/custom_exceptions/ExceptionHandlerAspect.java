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

    @Autowired
    private DBExceptionHandler dbExceptionHandler;


    @SneakyThrows
    @Around("execution(* aspect.services..*.*(..))")
    public Object handleDBException(ProceedingJoinPoint pjp) {
        Object retVal = null;
        try {
            retVal = pjp.proceed();
        } catch (DBException exception) {
            dbExceptionHandler.handle(exception);
        }
        return retVal;
    }

//    @SneakyThrows
//    @AfterThrowing(pointcut = "execution(* aspect.services..*.*(..))", throwing = "ex")
//    public void handleDBException(DBException ex) {
//            dbExceptionHandler.handle(ex);
//    }
}
