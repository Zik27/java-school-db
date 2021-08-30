package aspect.custom_exceptions.handlers;

import aspect.custom_exceptions.DBException;

public interface DBExceptionHandler {
    void handle(DBException ex);
}
