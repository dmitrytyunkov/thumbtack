package net.thumbtack.tyunkov.lessons;

import net.thumbtack.tyunkov.lessons.threads.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 22.11.15.
 */
public class ThreadTest {
    @Test
    public void testPrintPropertyThread() {
        Thread thread = Thread.currentThread();
        System.out.println(thread);
        assertNotNull(thread);
    }

    @Ignore
    @Test
    public void testCreateNewThread() {
        OneThread oneThread = new OneThread("One thread");
        assertTrue(oneThread.getThread().isAlive());
        try {
            oneThread.getThread().join();
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
        assertFalse(oneThread.getThread().isAlive());
    }

    @Ignore
    @Test
    public void testCreateMultiThread() {
        OneThread oneThread = new OneThread("One thread");
        TwoThread twoThread = new TwoThread("Two thread");
        ThreeThread threeThread = new ThreeThread("Three thread");
        assertTrue(oneThread.getThread().isAlive());
        assertTrue(twoThread.getThread().isAlive());
        assertTrue(threeThread.getThread().isAlive());
        try {
            oneThread.getThread().join();
            twoThread.getThread().join();
            threeThread.getThread().join();
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
        assertFalse(oneThread.getThread().isAlive());
        assertFalse(twoThread.getThread().isAlive());
        assertFalse(threeThread.getThread().isAlive());
    }

    @Test
    public void testSynchronizedBlock() {
        List<Integer> list = new ArrayList<>();
        Remover remover = new Remover(list);
        Adder adder = new Adder(list);
        try {
            adder.getThread().join();
            remover.getThread().join();
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
        assertEquals(0, list.size());
    }

    @Ignore
    @Test
    public void testSynchronizedMethod() {
        List<Integer> list = new ArrayList<>();
        AdderAndRemover adderAndRemover = new AdderAndRemover(list);
        AdderAndRemover adderAndRemover1 = new AdderAndRemover(list);
        try {
            adderAndRemover.getThread().join();
            adderAndRemover1.getThread().join();
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
        assertEquals(0, list.size());
    }

    @Ignore
    @Test
    public void testSynchronizedList() {
        List<Integer> list = new ArrayList<>();
        AdderAndRemover adderAndRemover = new AdderAndRemover(list);
        AdderAndRemover adderAndRemover1 = new AdderAndRemover(list);
        try {
            adderAndRemover.getThread().join();
            adderAndRemover1.getThread().join();
        } catch (InterruptedException ex) {
            fail(ex.getMessage());
        }
        assertEquals(0, list.size());
    }
}
