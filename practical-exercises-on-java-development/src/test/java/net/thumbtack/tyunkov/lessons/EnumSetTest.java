package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.fourth.Color;
import org.junit.Test;

import java.util.EnumSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by dmitry on 22.11.15.
 */
public class EnumSetTest {
    @Test
    public void testEnumSet() {
        EnumSet<Color> enumSet = EnumSet.allOf(Color.class);
        EnumSet<Color> enumSet1 = EnumSet.of(Color.RED);
        EnumSet<Color> enumSet2 = EnumSet.range(Color.RED, Color.BLUE);
        EnumSet<Color> enumSet3 = EnumSet.noneOf(Color.class);
        assertTrue(enumSet.contains(Color.GREEN));
        assertFalse(enumSet1.contains(Color.GREEN));
        assertTrue(enumSet2.contains(Color.GREEN));
        assertFalse(enumSet3.contains(Color.GREEN));
    }
}
