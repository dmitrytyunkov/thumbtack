package net.thumbtack.tyunkov.lessons.fourth;

import net.thumbtack.tyunkov.lessons.third.figures.Figure;

/**
 * Created by dmitry on 25.10.15.
 */
public class ArrayBox<T extends Figure> {

    private T[] obj;

    public ArrayBox() {
    }

    public ArrayBox(T[] obj) {
        this.obj = obj;
    }

    /*public T[] create(){
        return new T[];
    }*/


    public T[] getObj() {
        return obj;
    }

    public void setObj(T[] obj) {
        this.obj = obj;
    }
}
