package net.thumbtack.tyunkov.lessons.third.figures;

import net.thumbtack.tyunkov.lessons.fourth.Color;
import net.thumbtack.tyunkov.lessons.third.Colored;

/**
 * Created by dmitry on 24.10.15.
 */
public abstract class Figure implements Colored {

    protected Color color = Color.BLACK;

    public abstract void moveTo(double dX, double dY);

    public abstract double square();

    public abstract void printCoordinates();

    public abstract boolean isInside(double x, double y);

    public abstract boolean isInside(Point2D point2D);

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
