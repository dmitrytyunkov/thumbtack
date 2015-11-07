package net.thumbtack.tyunkov.lessons.fifth;

/**
 * Created by dmitry on 01.11.15.
 */
public enum TraineeErrorCode {
    NAME_INCORRECT("Name incorrect"),
    LAST_NAME_INCORRECT("Last name incorrect"),
    MARK_INCORRECT("Mark incorrect");
    private final String errorString;


    TraineeErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
