package net.thumbtack.tyunkov.lessons.exceptions;

/**
 * Created by dmitry on 15.11.15.
 */
public class InstituteException extends Exception {
    public InstituteException() {
    }

    public InstituteException(String message) {
        super(message);
    }

    public InstituteException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstituteException(Throwable cause) {
        super(cause);
    }
}
