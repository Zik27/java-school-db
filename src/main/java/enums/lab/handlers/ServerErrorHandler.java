package enums.lab.handlers;

public class ServerErrorHandler implements HandlerByHttpCodes {
    @Override
    public void execute() {
        System.out.println("It's Server Error Handler");
    }
}
