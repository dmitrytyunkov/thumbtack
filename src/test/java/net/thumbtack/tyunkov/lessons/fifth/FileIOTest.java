package net.thumbtack.tyunkov.lessons.fifth;

import com.sun.javafx.scene.layout.region.Margins;
import net.thumbtack.tyunkov.lessons.third.figures.*;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 01.11.15.
 */
public class FileIOTest {

    @Test
    public void testOutputStream() {
        Rectangle rectangle = new Rectangle(0,0,1,1);
        try (FileOutputStream fileOutputStream = new FileOutputStream("rectangle.dat")) {
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
        Rectangle[] rectangles = new Rectangle[5];
        rectangles[0] = new Rectangle();
        rectangles[1] = new Rectangle(2,3);
        rectangles[2] = new Rectangle(0,0,2,2);
        rectangles[3] = new Rectangle(3,3);
        rectangles[4] = new Rectangle(1,1,3,5);
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
            fileInputStream.skip(16);
            for (int i = 0; i < rectangles1.length; i++) {
                byte[] bytes = new byte[4];
                fileInputStream.read(bytes);
                rectangles1[i] = new Rectangle(bytes[0], bytes[1], bytes[2], bytes[3]);
                if (i != rectangles1.length - 1)
                    fileInputStream.skip(-8);
            }
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertTrue(rectangles1[0].equals(rectangles[4]));
        assertTrue(rectangles1[1].equals(rectangles[3]));
        assertTrue(rectangles1[2].equals(rectangles[2]));
        assertTrue(rectangles1[3].equals(rectangles[1]));
        assertTrue(rectangles1[4].equals(rectangles[0]));
    }

    @Test
    public void testPrintStream() {
        Rectangle rectangle = new Rectangle();
        try (PrintStream printStream = new PrintStream("printRectangle.dat"))
        {
            printStream.print(new Double(rectangle.getX1()).intValue());
            printStream.print(new Double(rectangle.getY1()).intValue());
            printStream.print(new Double(rectangle.getX2()).intValue());
            printStream.println(new Double(rectangle.getY2()).intValue());
        } catch (FileNotFoundException ex) {
            fail(ex.getMessage());
        }
        assertTrue(new File("printRectangle.dat").exists());
    }
}
