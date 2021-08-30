package aspect.custom_exceptions;

public class DBException extends RuntimeException {

    public DBException() {
        super();
    }

    public DBException(String message) {
        super(message);
    }
}
