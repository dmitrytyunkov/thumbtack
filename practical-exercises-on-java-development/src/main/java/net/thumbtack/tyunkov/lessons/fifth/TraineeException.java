package net.thumbtack.tyunkov.lessons.fifth;

/**
 * Created by dmitry on 01.11.15.
 */
public class TraineeException extends Exception {
    public TraineeException() {
    }

    public TraineeException(String message) {
        super(message);
    }

    public TraineeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TraineeException(Throwable cause) {
        super(cause);
    }
}
