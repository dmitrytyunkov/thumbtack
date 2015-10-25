package net.thumbtack.tyunkov.lessons.third.figures;

/**
 * Created by Dmitry on 04.10.2015.
 */
public class Point2D {

    private double x, y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        x = 20;
        y = 30;
    }

    public void moveTo(double dX, double dY) {
        x += dX;
        y += dY;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2D point2D = (Point2D) o;

        final double EPS = 1.0E-6;
        if (Math.abs(point2D.x - x) > EPS) return false;
        return Math.abs(point2D.y - y) < EPS;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
