package net.thumbtack.tyunkov.lessons.fourth;

import net.thumbtack.tyunkov.lessons.third.figures.Figure;
import net.thumbtack.tyunkov.lessons.third.figures.Rectangle;

/**
 * Created by dmitry on 25.10.15.
 */
public class Box<T extends Figure> implements Square<Figure> {

    private T obj;

    public Box(T obj) {
        super();
        this.obj = obj;
    }

    /*public T create() {
        return new T();
    }*/

    public double square() {
        return obj.square();
    }

    public boolean isSameSquare(Box<? extends Rectangle> obj) {
        final double EPS = 1.0E-6;
        return Math.abs(square() - obj.square()) < EPS;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
