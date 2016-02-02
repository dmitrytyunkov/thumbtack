package net.thumbtack.tyunkov.lessons.fourth;

import net.thumbtack.tyunkov.lessons.third.figures.Circle;
import net.thumbtack.tyunkov.lessons.third.figures.Point2D;
import net.thumbtack.tyunkov.lessons.third.figures.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by dmitry on 25.10.15.
 */
public class PairBoxTest {
    @Test
    public void firstPairBoxTest() throws Exception {
        PairBox<Rectangle, Circle> rectangleCirclePairBox = new PairBox<Rectangle, Circle>(new Rectangle(),
                new Circle(new Point2D(4, 4), Math.sqrt(1 / Math.PI)));
        assertTrue(rectangleCirclePairBox.isSameSquare());
    }
}
