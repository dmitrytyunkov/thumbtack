package net.thumbtack.tyunkov.lessons.third;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmitry on 18.10.15.
 */
public class ThirdTest {

    @Test
    public void integerClassWorking() {
        Integer i;
        int i1 = 5, i2;
        i = i1;
        assertEquals(i1, i.intValue());
        i2 = i;
        assertEquals(i.intValue(), i2);
    }

    @Test
    public void doubleClassWorking() {
        Double d;
        double d1 = 5624 * 1.0E-2, d2;
        d = d1;
        assertEquals(d1, d.doubleValue(), 1.0E-6);
        d2 = d;
        assertEquals(d.doubleValue(), d2, 1.0E-6);
    }
}
