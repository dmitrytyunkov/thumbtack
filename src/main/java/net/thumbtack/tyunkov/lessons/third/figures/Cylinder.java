package net.thumbtack.tyunkov.lessons.third.figures;


import net.thumbtack.tyunkov.lessons.fifth.ColorException;
import net.thumbtack.tyunkov.lessons.fourth.Color;

import java.util.Locale;

/**
 * Created by dmitry on 24.10.15.
 */
public class Cylinder extends Circle {

    private double height;

    public Cylinder(Point2D center, double radius, double height, String colorString) {
        super(center, radius, colorString);
        this.height = height;
    }

    public Cylinder(Point2D center, double radius, double height) {
        this(center, radius, height, Color.BLACK.toString());
    }

    public void printCoordinates() {
        super.printCoordinates();
        System.out.printf(Locale.ENGLISH, "height = %.2f", height);
        System.out.println();
    }

    public double volume() {
        return super.square() * height;
    }

    public double areaOfSideSurface() {
        return super.circumference() * height;
    }

    public boolean isInside(double x, double y, double z) {
        if (super.isInside(x, y))
            return z < height;
        else
            return false;
    }

    public boolean isInside(Point3D point) {
        return isInside(point.getX(), point.getY(), point.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cylinder cylinder = (Cylinder) o;

        final double EPS = 1.0E-6;
        return Math.abs(cylinder.height - height) < EPS;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
