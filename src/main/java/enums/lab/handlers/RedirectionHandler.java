package enums.lab.handlers;

public class RedirectionHandler implements HandlerByHttpCodes {
    @Override
    public void execute() {
        System.out.println("It's Redirection Handler");
    }
}
