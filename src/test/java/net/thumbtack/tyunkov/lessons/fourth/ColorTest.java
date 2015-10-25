package net.thumbtack.tyunkov.lessons.fourth;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by dmitry on 25.10.15.
 */
public class ColorTest {
    @Test
    public void firstColorTest() throws Exception {
        Color[] colors = Color.values();
        Color[] colors1 = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.WHITE, Color.BLACK};
        assertArrayEquals(colors1, colors);
    }
}
