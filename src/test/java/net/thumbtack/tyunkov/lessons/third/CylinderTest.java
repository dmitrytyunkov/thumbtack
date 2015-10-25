package net.thumbtack.tyunkov.lessons.third;

import net.thumbtack.tyunkov.lessons.third.figures.Cylinder;
import net.thumbtack.tyunkov.lessons.third.figures.Point2D;
import net.thumbtack.tyunkov.lessons.third.figures.Point3D;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dmitry on 24.10.15.
 */
public class CylinderTest {

    @Test
    public void testPrintCoordinates() throws Exception {
        Cylinder cylinder = new Cylinder(new Point2D(5, 4), 3, 6);
        System.out.println("Test printCoordinates");
        cylinder.printCoordinates();
    }

    @Test
    public void testSquare() throws Exception {
        Cylinder cylinder = new Cylinder(new Point2D(5, 4), 3, 6);
        assertEquals(cylinder.square(), 2.8274333882308E01, 1.0E-6);
    }

    @Test
    public void testVolume() throws Exception {
        Cylinder cylinder = new Cylinder(new Point2D(5, 4), 3, 6);
        assertEquals(cylinder.volume(), 1.6964600329385E02, 1.0E-6);
    }

    @Test
    public void testAreaOfSideSurface() throws Exception {
        Cylinder cylinder = new Cylinder(new Point2D(5, 4), 3, 6);
        assertEquals(cylinder.areaOfSideSurface(), 1.1309733552923E02, 1.0E-6);
    }

    @Test
    public void testIsInside() throws Exception {
        Cylinder cylinder = new Cylinder(new Point2D(5, 4), 3, 6);
        assertTrue(cylinder.isInside(3, 3, 3));
        assertTrue(cylinder.isInside(new Point3D(3, 3, 3)));
    }

    @Test
    public void testEquals() throws Exception {
        Cylinder cylinder = new Cylinder(new Point2D(5, 4), 3, 6);
        assertTrue(cylinder.equals(new Cylinder(new Point2D(2, 2), 3, 6)));
    }
}