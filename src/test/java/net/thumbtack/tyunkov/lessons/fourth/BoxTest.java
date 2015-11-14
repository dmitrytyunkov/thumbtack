package net.thumbtack.tyunkov.lessons.fourth;

import net.thumbtack.tyunkov.lessons.third.figures.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 25.10.15.
 */
public class BoxTest {

    // REVU why here ? Move to appropriate class
    // Это из занятия 4, задание 11. Там сказано написать статический generic метод, в классе
    // где находится main. А т.к. у меня нет отдельной функции с main, я написал этот метод здесь.
    // Так можно или сделать класс с main?
    static <T> boolean isSameSquareStatic(Box<? extends Figure> first, Box<? extends Figure> second) {
        final double EPS = 1.0E-6;
        return Math.abs(first.square() - second.square()) < EPS;
    }

    @Test
    public void firstBoxTest() throws Exception {
        Box<Rectangle> rectangleBox = new Box<Rectangle>(new Rectangle());
        Box<Rectangle3D> rectangle3DBox = new Box<Rectangle3D>(new Rectangle3D(2, 2, 3));
        //Box<String> stringBox = new Box<String>(new String("Hello World!"));
        double[] expectedCoord = {0.0, 0.0, 1.0, 1.0};
        double[] actualCoord = {rectangleBox.getObj().getX1(), rectangleBox.getObj().getY1(),
                rectangleBox.getObj().getX2(), rectangleBox.getObj().getY2()};
        assertArrayEquals(expectedCoord, actualCoord, 1.0E-6);
        double[] expectedCoord3D = {0.0, 0.0, 0.0, 2.0, 2.0, 3.0};
        double[] actualCoord3D = {rectangle3DBox.getObj().getX1(), rectangle3DBox.getObj().getY1(),
                rectangle3DBox.getObj().getZ1(), rectangle3DBox.getObj().getX2(),
                rectangle3DBox.getObj().getY2(), rectangle3DBox.getObj().getZ2()};
        assertArrayEquals(expectedCoord3D, actualCoord3D, 1.0E-6);
        //assertEquals("Hello World!",stringBox.getObj());
    }

    @Test
    public void secondBoxTest() throws Exception {
        Box<Rectangle> rectangleBox = new Box<Rectangle>(new Rectangle());
        assertEquals(new Rectangle().square(), rectangleBox.square(), 1.0E-6);
    }

    @Test
    public void thirdBoxTest() throws Exception {
        Box<Rectangle> rectangleBox = new Box<Rectangle>(new Rectangle());
        assertTrue(rectangleBox.isSameSquare(new Box<Rectangle>(new Rectangle(1, 1, 2, 2))));
        assertTrue(rectangleBox.isSameSquare(new Box<Rectangle3D>(new Rectangle3D(1, 1, 1, 2, 2, 2))));
    }

    @Test
    public void fourthBoxTest() throws Exception {
        Box<Rectangle> rectangleBox1 = new Box<Rectangle>(new Rectangle());
        Box<Rectangle> rectangleBox2 = new Box<Rectangle>(new Rectangle(1, 1, 2, 2));
        Box<Rectangle3D> rectangle3DBox = new Box<Rectangle3D>(new Rectangle3D(1, 1, 1, 2, 2, 5));
        Box<Cylinder> cylinderBox = new Box<Cylinder>(new Cylinder(new Point2D(0, 0), Math.sqrt(1 / Math.PI), 5));
        assertTrue(isSameSquareStatic(rectangleBox1, rectangleBox2));
        assertTrue(isSameSquareStatic(rectangleBox2, rectangle3DBox));
        assertTrue(isSameSquareStatic(rectangle3DBox, cylinderBox));
    }
}
