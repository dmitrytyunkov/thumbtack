package net.thumbtack.tyunkov.lessons.fourth;

import net.thumbtack.tyunkov.lessons.third.figures.Figure;

/**
 * Created by dmitry on 25.10.15.
 */
public interface Square<T extends Figure> {
    public double square();
}
