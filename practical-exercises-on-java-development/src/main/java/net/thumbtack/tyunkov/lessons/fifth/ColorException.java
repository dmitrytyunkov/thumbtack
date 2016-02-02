package net.thumbtack.tyunkov.lessons.fifth;

/**
 * Created by dmitry on 01.11.15.
 */
public class ColorException extends Exception {

    public ColorException() {
        super();
    }

    public ColorException(String message) {
        super(message);
    }

    public ColorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColorException(Throwable cause) {
        super(cause);
    }
}
