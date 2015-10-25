package net.thumbtack.tyunkov.lessons.third;

import net.thumbtack.tyunkov.lessons.third.figures.*;
import org.junit.Test;

/**
 * Created by dmitry on 24.10.15.
 */
public class SixthTest {
    @Test
    public void testFigure() throws Exception {
        Rectangle3D rectangle3D = new Rectangle3D();
        Figure figure = rectangle3D;
        System.out.println("Rectangle3D");
        figure.printCoordinates();
        Rectangle rectangle = new Rectangle();
        figure = rectangle;
        System.out.println("Rectangle");
        figure.printCoordinates();
        Cylinder cylinder = new Cylinder(new Point2D(5, 4), 3, 6);
        figure = cylinder;
        System.out.println("Cylinder");
        figure.printCoordinates();
        Circle circle = new Circle(new Point2D(2, 6), 4);
        figure = circle;
        System.out.println("Circle");
        figure.printCoordinates();
    }
}
