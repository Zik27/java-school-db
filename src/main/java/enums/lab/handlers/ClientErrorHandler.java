package enums.lab.handlers;

public class ClientErrorHandler implements HandlerByHttpCodes {
    @Override
    public void execute() {
        System.out.println("It's Client Error Handler");
    }
}
