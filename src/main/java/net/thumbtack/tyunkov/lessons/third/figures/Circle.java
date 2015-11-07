package net.thumbtack.tyunkov.lessons.third.figures;


import net.thumbtack.tyunkov.lessons.fifth.ColorException;
import net.thumbtack.tyunkov.lessons.fourth.Color;

import java.util.Locale;

/**
 * Created by Dmitry on 17.10.2015.
 */
public class Circle extends Figure {

    private Point2D center;
    private double radius;

    public Circle(Point2D center, double radius, String colorString) {
        this.center = center;
        this.radius = radius;
        try {
            setColor(colorString);
        } catch (ColorException ex) {
            setColor(Color.BLACK);
        }
    }

    public Circle(Point2D center, double radius) {
        this(center, radius, Color.BLACK.toString());
    }

    public void printCoordinates() {
        System.out.printf(Locale.ENGLISH, "center (%.2f, %.2f)", center.getX(), center.getY());
        System.out.println();
        System.out.printf(Locale.ENGLISH, "radius = %.2f", radius);
        System.out.println();
    }

    public void moveTo(double dX, double dY) {
        center.moveTo(dX, dY);
    }

    public double square() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public boolean isInside(double x, double y) {
        double a = Math.sqrt(Math.pow((center.getX() - x), 2) + Math.pow((center.getY() - y), 2));
        return a < radius;
    }

    public boolean isInside(Point2D point) {
        /*double a = Math.sqrt(Math.pow((center.getX() - point.getX()), 2) + Math.pow((center.getY() - point.getY()), 2));
        return a<radius;*/
        return isInside(point.getX(), point.getY());
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        final double EPS = 1.0E-6;
        return (Math.abs(radius - circle.getRadius()) < EPS);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = center.hashCode();
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
