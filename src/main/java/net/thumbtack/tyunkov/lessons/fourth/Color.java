package net.thumbtack.tyunkov.lessons.fourth;

import net.thumbtack.tyunkov.lessons.fifth.ColorException;

/**
 * Created by dmitry on 25.10.15.
 */
public enum Color {
    RED, GREEN, BLUE, YELLOW, WHITE, BLACK;

    public static Color fromString(String colorString) throws ColorException {
        try {
            return Color.valueOf(colorString);
        } catch (IllegalArgumentException ex) {
            throw new ColorException("Incorrect color");
        }
    }
}
