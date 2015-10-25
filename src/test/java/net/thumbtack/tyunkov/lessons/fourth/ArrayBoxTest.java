package net.thumbtack.tyunkov.lessons.fourth;

import net.thumbtack.tyunkov.lessons.third.figures.Rectangle;
import net.thumbtack.tyunkov.lessons.third.figures.Rectangle3D;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by dmitry on 25.10.15.
 */
public class ArrayBoxTest {
    @Test
    public void firstBoxTest() throws Exception {
        Rectangle[] rectangles = {new Rectangle(), new Rectangle(5, 5), new Rectangle(1, 1, 3, 3)};
        Rectangle3D[] rectangles3D = {new Rectangle3D(), new Rectangle3D(5, 5, 4), new Rectangle3D(1, 1, 0, 3, 3, 5)};
        String[] strings = {"Hello", "World"};
        ArrayBox<Rectangle> rectangleArrayBox = new ArrayBox<Rectangle>(rectangles);
        ArrayBox<Rectangle3D> rectangle3DArrayBox = new ArrayBox<Rectangle3D>(rectangles3D);
        //ArrayBox<String> stringArrayBox = new ArrayBox<String>(strings);
        double[][] expectedCoord = {{0.0, 0.0, 1.0, 1.0}, {0, 0, 5, 5}, {1, 1, 3, 3}};
        double[][] actualCoord = {{rectangleArrayBox.getObj()[0].getX1(), rectangleArrayBox.getObj()[0].getY1(),
                rectangleArrayBox.getObj()[0].getX2(), rectangleArrayBox.getObj()[0].getY2()},
                {rectangleArrayBox.getObj()[1].getX1(), rectangleArrayBox.getObj()[1].getY1(),
                        rectangleArrayBox.getObj()[1].getX2(), rectangleArrayBox.getObj()[1].getY2()},
                {rectangleArrayBox.getObj()[2].getX1(), rectangleArrayBox.getObj()[2].getY1(),
                        rectangleArrayBox.getObj()[2].getX2(), rectangleArrayBox.getObj()[2].getY2()}};
        assertArrayEquals(expectedCoord[0], actualCoord[0], 1.0E-6);
        assertArrayEquals(expectedCoord[1], actualCoord[1], 1.0E-6);
        assertArrayEquals(expectedCoord[2], actualCoord[2], 1.0E-6);
        double[][] expectedCoord3D = {{0.0, 0.0, 0.0, 1.0, 1.0, 1.0}, {0, 0, 0, 5, 5, 4}, {1, 1, 0, 3, 3, 5}};
        double[][] actualCoord3D = {{rectangle3DArrayBox.getObj()[0].getX1(), rectangle3DArrayBox.getObj()[0].getY1(),
                rectangle3DArrayBox.getObj()[0].getZ1(), rectangle3DArrayBox.getObj()[0].getX2(),
                rectangle3DArrayBox.getObj()[0].getY2(), rectangle3DArrayBox.getObj()[0].getZ2()},
                {rectangle3DArrayBox.getObj()[1].getX1(), rectangle3DArrayBox.getObj()[1].getY1(),
                        rectangle3DArrayBox.getObj()[1].getZ1(), rectangle3DArrayBox.getObj()[1].getX2(),
                        rectangle3DArrayBox.getObj()[1].getY2(), rectangle3DArrayBox.getObj()[1].getZ2()},
                {rectangle3DArrayBox.getObj()[2].getX1(), rectangle3DArrayBox.getObj()[2].getY1(),
                        rectangle3DArrayBox.getObj()[2].getZ1(), rectangle3DArrayBox.getObj()[2].getX2(),
                        rectangle3DArrayBox.getObj()[2].getY2(), rectangle3DArrayBox.getObj()[2].getZ2()}};
        assertArrayEquals(expectedCoord3D[0], actualCoord3D[0], 1.0E-6);
        assertArrayEquals(expectedCoord3D[1], actualCoord3D[1], 1.0E-6);
        assertArrayEquals(expectedCoord3D[2], actualCoord3D[2], 1.0E-6);
        //assertEquals("Hello World!",stringBox.getObj());
    }
}
