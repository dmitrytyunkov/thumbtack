package net.thumbtack.tyunkov.lessons;

import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by dmitry on 22.11.15.
 */
public class BitSetTest {
    @Test
    public void testAdd(){
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(5);
        bitSet.set(35);
        assertEquals(3, bitSet.cardinality());
        assertEquals(36, bitSet.length());
    }

    @Test
    public void testSearch(){
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(5);
        bitSet.set(35);
        assertTrue(bitSet.get(5));
    }

    @Test
    public void testDelete(){
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(5);
        bitSet.set(35);
        assertTrue(bitSet.get(5));
        bitSet.clear(5);
        assertFalse(bitSet.get(5));
    }
}
