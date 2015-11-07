package net.thumbtack.tyunkov.lessons.third;

import net.thumbtack.tyunkov.lessons.fifth.ColorException;
import net.thumbtack.tyunkov.lessons.fourth.Color;

/**
 * Created by dmitry on 24.10.15.
 */
public interface Colored {
    Color getColor();

    void setColor(String color) throws ColorException;

    void setColor(Color color);
}
