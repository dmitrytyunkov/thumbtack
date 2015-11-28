package net.thumbtack.tyunkov.lessons.fourth;

import net.thumbtack.tyunkov.lessons.fifth.ColorException;

/**
 * Created by dmitry on 25.10.15.
 */
public enum Color {
    RED, GREEN, BLUE, YELLOW, WHITE, BLACK;

	// REVU you do not need in this field at all
    private static Color color;

    // REVU this method must return Color (or throw exception)
    public static void fromString(String colorString) throws ColorException {
        try {
            color = Color.valueOf(colorString);
        } catch (IllegalArgumentException ex) {
            throw new ColorException("Incorrect color");
        }
    }

    // REVU this method is unnecessary
    public static Color getColor() {
        return color;
    }
}
