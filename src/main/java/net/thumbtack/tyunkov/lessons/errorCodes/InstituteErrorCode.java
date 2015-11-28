package net.thumbtack.tyunkov.lessons.errorCodes;

/**
 * Created by dmitry on 15.11.15.
 */
public enum InstituteErrorCode {
    TITLE_INCORRECT("Title incorrect"),
    TRAINEE_INCORRECT("Trainee incorrect");

    private final String errorString;

    InstituteErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
