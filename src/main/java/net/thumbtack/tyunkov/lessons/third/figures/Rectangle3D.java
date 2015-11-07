package net.thumbtack.tyunkov.lessons.third.figures;

import net.thumbtack.tyunkov.lessons.fifth.ColorException;
import net.thumbtack.tyunkov.lessons.fourth.Color;

import java.util.Locale;

/**
 * Created by dmitry on 18.10.15.
 */
public class Rectangle3D extends Rectangle {

    private double z1, z2;

    public Rectangle3D(double x1, double y1, double z1, double x2, double y2, double z2, String colorString) {
        super(x1, y1, x2, y2, colorString);
        this.z1 = z1;
        this.z2 = z2;
    }

    public Rectangle3D(double x1, double y1, double z1, double x2, double y2, double z2) {
        this(x1, y1, z1, x2, y2, z2, Color.BLACK.toString());
    }

    public Rectangle3D(double length, double width, double height) {
        this(0, 0, 0, length, width, height);
    }

    public Rectangle3D() {
        this(1, 1, 1);
    }

    public void printCoordinates() {
        System.out.printf(Locale.ENGLISH, "x1-y1-z1 (%.2f, %.2f, %.2f)", this.getX1(), this.getY1(), z1);
        System.out.println();
        System.out.printf(Locale.ENGLISH, "x2-y1-z1 (%.2f, %.2f, %.2f)", this.getX2(), this.getY1(), z1);
        System.out.println();
        System.out.printf(Locale.ENGLISH, "x1-y2-z1 (%.2f, %.2f, %.2f)", this.getX1(), this.getY2(), z1);
        System.out.println();
        System.out.printf(Locale.ENGLISH, "x1-y1-z2 (%.2f, %.2f, %.2f)", this.getX1(), this.getY1(), z2);
        System.out.println();
        System.out.printf(Locale.ENGLISH, "x2-y2-z1 (%.2f, %.2f, %.2f)", this.getX2(), this.getY2(), z1);
        System.out.println();
        System.out.printf(Locale.ENGLISH, "x1-y2-z2 (%.2f, %.2f, %.2f)", this.getX1(), this.getY2(), z2);
        System.out.println();
        System.out.printf(Locale.ENGLISH, "x2-y1-z2 (%.2f, %.2f, %.2f)", this.getX2(), this.getY1(), z2);
        System.out.println();
        System.out.printf(Locale.ENGLISH, "x2-y2-z2 (%.2f, %.2f, %.2f)", this.getX2(), this.getY2(), z2);
        System.out.println();
    }

    public void moveTo(double dX, double dY, double dZ) {
        super.moveTo(dX, dY);
        z1 += dZ;
        z2 += dZ;
    }

    public void reduction(double nX, double nY, double nZ) {
        super.reduction(nX, nY);
        z2 = z1 + (z2 - z1) / nZ;
    }

    /*public double volume(){
        return super.square() * (z2 - z1);
    }*/

    public boolean isInside(double x, double y, double z) {
        if (super.isInside(x, y))
            return (z > z1 && z < z2);
        else
            return false;
    }

    public boolean isInside(Point3D point) {
        return isInside(point.getX(), point.getY(), point.getZ());
    }

    public boolean isIntersection(Rectangle3D rectangle) {
        if (super.isIntersection(rectangle))
            return ((rectangle.getZ1() < z2 && rectangle.getZ1() >= z1) || (rectangle.getZ2() <= z2 && rectangle.getZ2() > z1));
        else
            return false;
    }

    public boolean isEmbedded(Rectangle3D rectangle) {
        if (super.isEmbedded(rectangle))
            return (rectangle.getZ1() >= z1 && rectangle.getZ2() <= z2);
        else
            return false;
    }

    public double getZ1() {
        return z1;
    }

    public void setZ1(double z1) {
        this.z1 = z1;
    }

    public double getZ2() {
        return z2;
    }

    public void setZ2(double z2) {
        this.z2 = z2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Rectangle3D that = (Rectangle3D) o;

        final double EPS = 1.0E-6;
        return (Math.abs((z2 - z1) - (that.getZ2() - that.getZ1())) < EPS);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(z1);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
