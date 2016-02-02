package net.thumbtack.tyunkov.lessons.fourth;

import net.thumbtack.tyunkov.lessons.third.figures.Figure;

/**
 * Created by dmitry on 25.10.15.
 */
public class PairBox<T extends Figure, V extends Figure> {
    private T objT;
    private V objV;

    public PairBox(T objT, V objV) {
        this.objT = objT;
        this.objV = objV;
    }

    public boolean isSameSquare() {
        final double EPS = 1.0E-6;
        return Math.abs(objT.square() - objV.square()) < EPS;
    }

    public T getObjT() {
        return objT;
    }

    public void setObjT(T objT) {
        this.objT = objT;
    }

    public V getObjV() {
        return objV;
    }

    public void setObjV(V objV) {
        this.objV = objV;
    }
}
