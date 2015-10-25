package net.thumbtack.tyunkov.lessons.third;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmitry on 18.10.15.
 */
public class SecondTest {

    @Test
    public void stringBuilderWorking() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        assertEquals("Hello", stringBuilder.toString());
        stringBuilder.append("!!!");
        assertEquals("Hello!!!", stringBuilder.toString());
        stringBuilder.insert(5, " World");
        assertEquals("Hello World!!!", stringBuilder.toString());
    }
}
