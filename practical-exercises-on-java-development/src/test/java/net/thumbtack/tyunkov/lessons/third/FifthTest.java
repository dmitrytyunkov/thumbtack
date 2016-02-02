package net.thumbtack.tyunkov.lessons.third;

import net.thumbtack.tyunkov.lessons.third.figures.*;
import org.junit.Test;

/**
 * Created by dmitry on 24.10.15.
 */
public class FifthTest {
    @Test
    public void testRectangle() throws Exception {
        Rectangle3D rectangle3D = new Rectangle3D();
        Rectangle rectangle = rectangle3D;
        System.out.println("Rectangle3D");
        rectangle.printCoordinates();
    }

    @Test
    public void testCircle() throws Exception {
        Cylinder cylinder = new Cylinder(new Point2D(3, 2), 5, 2);
        Circle circle = cylinder;
        System.out.println("Cylinder");
        circle.printCoordinates();
    }
}
