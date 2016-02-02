package net.thumbtack.tyunkov.lessons.fourth;

import net.thumbtack.tyunkov.lessons.third.figures.Figure;

/**
 * Created by dmitry on 25.10.15.
 */
public class NamedArrayBox<T extends Figure> extends ArrayBox<T> {
    private String nameBox;

    public String getNameBox() {
        return nameBox;
    }

    public void setNameBox(String nameBox) {
        this.nameBox = nameBox;
    }
}
