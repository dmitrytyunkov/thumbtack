package net.thumbtack.tyunkov.lessons.fifth;

import net.thumbtack.tyunkov.lessons.third.figures.Rectangle;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by dmitry on 01.11.15.
 */
public class BinIOTest {

    @Test
    public void testOutputStream() {
        File file = new File("rectangle.dat");
        if (file.exists())
            file.delete();
        Rectangle rectangle = new Rectangle(0, 0, 1, 1);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(new Double(rectangle.getX1()).intValue());
            fileOutputStream.write(new Double(rectangle.getY1()).intValue());
            fileOutputStream.write(new Double(rectangle.getX2()).intValue());
            fileOutputStream.write(new Double(rectangle.getY2()).intValue());
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        //fileOutputStream.write(rectangle.getColor().toString().getBytes());
        assertTrue(new File("rectangle.dat").exists());
    }

    @Test
    public void testInputStream() {
        File file = new File("rectangle.dat");
        if (!file.exists())
            testOutputStream();
        byte[] bytes = new byte[4];
        try (FileInputStream fileInputStream = new FileInputStream("rectangle.dat")) {
            fileInputStream.read(bytes);
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        Rectangle rectangle = new Rectangle(bytes[0], bytes[1], bytes[2], bytes[3]);
        assertTrue(rectangle.equals(new Rectangle()));
    }

    @Test
    public void testOutputInputStream() {
        File file = new File("rectangles.dat");
        if (file.exists())
            file.delete();
        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0] = new Rectangle();
        rectangles[1] = new Rectangle(2, 3);
        rectangles[2] = new Rectangle(0, 0, 2, 2);
        rectangles[3] = new Rectangle(3, 3);
        rectangles[4] = new Rectangle(1, 1, 3, 5);
        try (FileOutputStream fileOutputStream = new FileOutputStream("rectangles.dat")) {
            for (int i = 0; i < rectangles.length; i++) {
                fileOutputStream.write(new Double(rectangles[i].getX1()).intValue());
                fileOutputStream.write(new Double(rectangles[i].getY1()).intValue());
                fileOutputStream.write(new Double(rectangles[i].getX2()).intValue());
                fileOutputStream.write(new Double(rectangles[i].getY2()).intValue());
            }
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertTrue(new File("rectangles.dat").exists());
        Rectangle[] rectangles1 = new Rectangle[5];
        try (FileInputStream fileInputStream = new FileInputStream("rectangles.dat")) {
            fileInputStream.skip(20);
            for (int i = 0; i < rectangles1.length; i++) {
                fileInputStream.skip(-4);
                byte[] bytes = new byte[4];
                fileInputStream.read(bytes);
                rectangles1[i] = new Rectangle(bytes[0], bytes[1], bytes[2], bytes[3]);
                fileInputStream.skip(-4);
            }
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        for (int i = 0; i < rectangles1.length; i++)
            assertTrue(rectangles1[i].equals(rectangles[4 - i]));
    }

    @Test
    public void testPrintStream() {
        File file = new File("printRectangle.dat");
        if (file.exists())
            file.delete();
        Rectangle rectangle = new Rectangle();
        try (PrintStream printStream = new PrintStream(file)) {
            printStream.write(new Double(rectangle.getX1()).intValue());
            printStream.write(new Double(rectangle.getY1()).intValue());
            printStream.write(new Double(rectangle.getX2()).intValue());
            printStream.write(new Double(rectangle.getY2()).intValue());
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
        }
        assertTrue(new File("printRectangle.dat").exists());
    }
}
