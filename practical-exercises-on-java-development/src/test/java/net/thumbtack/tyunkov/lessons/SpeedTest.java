package net.thumbtack.tyunkov.lessons;

import org.junit.Test;


import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.nanoTime;
import static org.junit.Assert.*;

/**
 * Created by dmitry on 15.11.15.
 */
public class SpeedTest {

    @Test
    public void testComparisonSpeedArrayAndLinkedList() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long start = nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long end = nanoTime();
        long timeArrayList = end - start;
        System.out.println("Fill array list: " + timeArrayList*Math.pow(10,-9));

        start = nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        end = nanoTime();
        long timeLinkedList = end - start;
        System.out.println("Fill linked list: " + timeLinkedList*Math.pow(10,-9));

        start = nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.get(new Random().nextInt(100000));
        }
        end = nanoTime();
        timeArrayList = end - start;
        System.out.println("Random get from array list: " + timeArrayList*Math.pow(10,-9));

        start = nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.get(new Random().nextInt(100000));
        }
        end = nanoTime();
        timeLinkedList = end - start;
        System.out.println("Random get from linked list: " + timeLinkedList*Math.pow(10,-9));

        assertTrue(timeLinkedList>timeArrayList);
    }

    @Test
    public void testComparisonSpeedArrayListAndSets() {
        List<Integer> arrayList = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        long start = nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long end = nanoTime();
        long timeArrayList = end - start;
        System.out.println("Fill array list: " + timeArrayList*Math.pow(10,-9));

        start = nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashSet.add(i);
        }
        end = nanoTime();
        long timeHashSet = end - start;
        System.out.println("Fill hash set: " + timeHashSet*Math.pow(10,-9));

        start = nanoTime();
        for (int i = 0; i < 100000; i++) {
            treeSet.add(i);
        }
        end = nanoTime();
        long timeTreeSet = end - start;
        System.out.println("Fill tree set: " + timeTreeSet*Math.pow(10,-9));

        start = nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.contains(new Random().nextInt(100000));
        }
        end = nanoTime();
        timeArrayList = end - start;
        System.out.println("Random get from array list: " + timeArrayList*Math.pow(10,-9));

        start = nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashSet.contains(new Random().nextInt(100000));
        }
        end = nanoTime();
        timeHashSet = end - start;
        System.out.println("Random get from hash set: " + timeHashSet*Math.pow(10,-9));

        start = nanoTime();
        for (int i = 0; i < 100000; i++) {
            treeSet.contains(new Random().nextInt(100000));
        }
        end = nanoTime();
        timeTreeSet = end - start;
        System.out.println("Random get from tree set: " + timeTreeSet*Math.pow(10,-9));

        assertTrue(timeArrayList>timeTreeSet && timeTreeSet>timeHashSet);
    }

    @Test
    public void testComparisonSpeedSets() {
        BitSet bitSet = new BitSet();
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        long start = nanoTime();
        for (int i = 0; i < 1000000; i++) {
            bitSet.set(i);
        }
        long end = nanoTime();
        long timeBitSet = end - start;
        System.out.println("Fill bit set: " + timeBitSet*Math.pow(10,-9));

        start = nanoTime();
        for (int i = 0; i < 1000000; i++) {
            hashSet.add(i);
        }
        end = nanoTime();
        long timeHashSet = end - start;
        System.out.println("Fill hash set: " + timeHashSet*Math.pow(10,-9));

        start = nanoTime();
        for (int i = 0; i < 1000000; i++) {
            treeSet.add(i);
        }
        end = nanoTime();
        long timeTreeSet = end - start;
        System.out.println("Fill tree set: " + timeTreeSet*Math.pow(10,-9));

        assertTrue(timeBitSet<timeHashSet/* && timeTreeSet<timeHashSet*/);
    }
}
