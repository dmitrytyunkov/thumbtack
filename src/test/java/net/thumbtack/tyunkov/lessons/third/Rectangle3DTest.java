package net.thumbtack.tyunkov.lessons.third;

import net.thumbtack.tyunkov.lessons.third.figures.Point3D;
import net.thumbtack.tyunkov.lessons.third.figures.Rectangle3D;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dmitry on 18.10.15.
 */
public class Rectangle3DTest {

    @Test
    public void testMoveTo() throws Exception {
        Rectangle3D rectangle3D = new Rectangle3D(3, 3, 3);
        rectangle3D.moveTo(1, 1, 1);
        System.out.println("Test moveTo");
        rectangle3D.printCoordinates();
    }

    @Test
    public void testReduction() throws Exception {
        Rectangle3D rectangle3D = new Rectangle3D(3, 3, 3);
        rectangle3D.reduction(2, 2, 2);
        System.out.println("Test reduction");
        rectangle3D.printCoordinates();
    }

    @Test
    public void testSquare() throws Exception {
        Rectangle3D rectangle3D = new Rectangle3D(3, 3, 3);
        assertEquals(rectangle3D.square(), 9, 1.0E-6);
    }

    @Test
    public void testVolume() throws Exception {
        double volume = new Rectangle3D(3, 3, 3) {
            public double volume() {
                return super.square() * (z2 - z1);
            }
        }.volume();
        assertEquals(volume, 27, 1.0E-6);
    }

    @Test
    public void testIsInside() throws Exception {
        Rectangle3D rectangle3D = new Rectangle3D(3, 3, 3);
        assertTrue(rectangle3D.isInside(1, 1, 1));
        assertTrue(rectangle3D.isInside(new Point3D(2, 2, 2)));
    }

    @Test
    public void testIsIntersection() throws Exception {
        Rectangle3D rectangle3D = new Rectangle3D(3, 3, 3);
        assertTrue(rectangle3D.isIntersection(new Rectangle3D(1, 1, 1)));
    }

    @Test
    public void testIsEmbedded() throws Exception {
        Rectangle3D rectangle3D = new Rectangle3D(3, 3, 3);
        assertTrue(rectangle3D.isEmbedded(new Rectangle3D(1, 1, 1)));
    }

    @Test
    public void testEquals() throws Exception {
        Rectangle3D rectangle3D = new Rectangle3D(3, 3, 3);
        Rectangle3D rectangle3D1 = new Rectangle3D(1, 1, 1, 4, 4, 4);
        assertTrue(rectangle3D.equals(rectangle3D1));
    }
}