package net.thumbtack.tyunkov.lessons.third;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 18.10.15.
 */
public class FirstTest {

    @Test
    public void testStringWorking() throws Exception {
        String string = "Hello World!";
        assertEquals(12, string.length());
        assertEquals(' ', string.charAt(5));
        assertEquals(11, string.indexOf(0x21));
        assertEquals(7, string.indexOf(0x6F, 5));
        assertEquals(2, string.indexOf("l"));
        assertEquals(3, string.indexOf("l", 3));
        assertEquals(11, string.lastIndexOf(0x21));
        assertEquals(4, string.lastIndexOf(0x6F, 5));
        assertEquals(9, string.lastIndexOf("l"));
        assertEquals(3, string.lastIndexOf("l", 6));
        assertTrue(string.equals("Hello World!"));
        assertFalse(string.equals("Hello world!"));
        assertTrue(string.equalsIgnoreCase("hello world!"));
        assertTrue(string.compareTo("Hello World") > 0);
        assertTrue(string.compareTo("Hello World!") == 0);
        assertTrue(string.compareTo("Hello world!") < 0);
        assertTrue(string.compareToIgnoreCase("hello world") > 0);
        assertTrue(string.compareToIgnoreCase("Hello World!!") < 0);
        assertTrue(string.compareToIgnoreCase("Hello world!") == 0);
        assertEquals("Hello World!!!", string.concat("!!"));
        assertEquals("Hello World!!!", string + "!!");
        assertEquals("Hello World!!!", string += "!!");
        assertTrue(string.startsWith("Hello"));
        assertTrue(string.endsWith("!!!"));
        assertEquals("lo W", string.substring(3, 7));
        byte[] bytes = {0x48, 0x65, 0x6C, 0x6C};
        assertArrayEquals(bytes, string.substring(0, 4).getBytes());
        char[] chars = {'H', 'e', 'l', 'l'};
        char[] chars1 = new char[4];
        string.getChars(0, 4, chars1, 0);
        assertArrayEquals(chars, chars1);
        assertEquals("He11o Wor1d!!!", string.replace('l', '1'));
        assertEquals("He1lo World!!!", string.replaceFirst("l", "1"));
        String[] strings = {"Hello", "World!!!"};
        assertArrayEquals(strings, string.split(" "));
        assertEquals("Hello", "    Hello   ".trim());
        assertEquals("0.001", String.valueOf(1.0E-3));
        assertEquals("0.0010", String.format(Locale.ENGLISH, "%.4f", 1.0E-3));
    }
}