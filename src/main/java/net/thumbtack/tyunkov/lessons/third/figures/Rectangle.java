package net.thumbtack.tyunkov.lessons.third.figures;


import net.thumbtack.tyunkov.lessons.fourth.Color;

/**
 * Created by Dmitry on 04.10.2015.
 */
public class Rectangle extends Figure {

    protected double x1, y1, x2, y2;

    public Rectangle(double x1, double y1, double x2, double y2, String colorString) {
        if (x2 < x1 || y2 < y1)
            throw new RuntimeException("First the coordinates of the  bottom-left corner and then the top-right");
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        try {
            color = Color.valueOf(colorString);
        } catch (IllegalArgumentException e) {
            color = Color.BLACK;
        }
    }

    public Rectangle(double x1, double y1, double x2, double y2) {
        this(x1, y1, x2, y2, Color.BLACK.toString());
    }

    public Rectangle(double width, double height) {
        this(0, 0, width, height);
    }

    public Rectangle() {
        this(0, 0, 1, 1);
    }

    public void printCoordinates() {
        System.out.println("bottom-left (" + Math.round(x1 * 100) / 100.0 + ", " + Math.round(y1 * 100) / 100.0 + ")");
        System.out.println("top-left (" + Math.round(x1 * 100) / 100.0 + ", " + Math.round(y2 * 100) / 100.0 + ")");
        System.out.println("top-right (" + Math.round(x2 * 100) / 100.0 + ", " + Math.round(y2 * 100) / 100.0 + ")");
        System.out.println("bottom-right (" + Math.round(x2 * 100) / 100.0 + ", " + Math.round(y1 * 100) / 100.0 + ")");
    }

    public void moveTo(double dX, double dY) {
        x1 += dX;
        x2 += dX;
        y1 += dY;
        y2 += dY;
    }

    public void reduction(double nX, double nY) {
        x2 = x1 + (x2 - x1) / nX;
        y2 = y1 + (y2 - y1) / nY;
    }

    public Rectangle large(double n) {
        double x2 = x1 + (this.x2 - this.x1) * n;
        double y2 = y1 + (this.y2 - this.y1) * n;
        return new Rectangle(x1, y1, x2, y2);
    }

    public double square() {
        return (x2 - x1) * (y2 - y1);
    }

    public boolean isInside(double x, double y) {
        return (((x > x1 && x < x2) && (y > y1 && y < y2)));
    }

    public boolean isInside(Point2D point) {
        //return (((point.getX()>x1&&point.getX()<x2)&&(point.getY()>y1&&point.getY()<y2)));
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersection(Rectangle rectangle) {
        return (((rectangle.getX1() < x2 && rectangle.getX1() >= x1) || (rectangle.getX2() <= x2 && rectangle.getX2() > x1)) &&
                ((rectangle.getY1() < y2 && rectangle.getY1() >= y1) || (rectangle.getY2() <= y2 && rectangle.getY2() > y1)));
    }

    public boolean isEmbedded(Rectangle rectangle) {
        return (rectangle.getX1() >= x1 && rectangle.getX2() <= x2 && rectangle.getY1() >= y1 && rectangle.getY2() <= y2);
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        final double EPS = 1.0E-6;
        if (Math.abs((x2 - x1) - (rectangle.getX2() - rectangle.getX1())) > EPS) return false;
        return (Math.abs((y2 - y1) - (rectangle.getY2() - rectangle.getY1())) < EPS);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x1);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y1);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
