package net.thumbtack.tyunkov.lessons.third;

import net.thumbtack.tyunkov.lessons.fourth.Color;
import net.thumbtack.tyunkov.lessons.third.cars.Car;
import net.thumbtack.tyunkov.lessons.third.figures.Circle;
import net.thumbtack.tyunkov.lessons.third.figures.Point2D;
import net.thumbtack.tyunkov.lessons.third.figures.Rectangle3D;
import org.junit.Test;

/**
 * Created by dmitry on 24.10.15.
 */
public class SeventhTest {
    @Test
    public void testColored() throws Exception {
        Rectangle3D rectangle3D = new Rectangle3D();
        Colored colored = rectangle3D;
        colored.setColor("Black");
        System.out.println(colored.getColor());
        Car car = new Car("Volkswagen Passat", 1500, 200);
        colored = car;
        colored.setColor("Blue");
        System.out.println(colored.getColor());
        Circle circle = new Circle(new Point2D(3, 3), 3);
        circle.setColor("Green");
        colored = circle;
        System.out.println(colored.getColor());
    }
}
