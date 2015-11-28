package net.thumbtack.tyunkov.lessons;

import org.junit.Test;

/**
 * Created by dmitry on 22.11.15.
 */
public class ThreadTest {
    @Test
    public void testPrintPropertyThread() {
        Thread thread = Thread.currentThread();
        System.out.println(thread);
    }
}
