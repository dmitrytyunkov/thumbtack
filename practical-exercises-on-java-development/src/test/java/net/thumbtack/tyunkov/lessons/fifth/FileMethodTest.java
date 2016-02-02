package net.thumbtack.tyunkov.lessons.fifth;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 01.11.15.
 */
public class FileMethodTest {
    File file = new File("/home/dmitry/temp.dat");
    File dir = new File("/home/dmitry/temp/");

    @Test
    public void testWorkingFile() {
        boolean isCreated = false;
        try {
            isCreated = file.createNewFile();
        } catch (IOException ex) {
            fail("IOException");
        }
        assertTrue(isCreated);
        assertTrue(file.renameTo(file = new File("/home/dmitry/temp.txt")));
        assertTrue(file.delete());
    }

    @Test
    public void testWorkingDir() {
        assertTrue(dir.mkdir());
        assertTrue(dir.renameTo(dir = new File("/home/dmitry/tem")));
        assertTrue(dir.delete());
    }

    @Test
    public void testAbsoluteNameFile() {
        assertEquals("/home/dmitry/temp.dat", file.getAbsolutePath());
    }

    @Test
    public void testIsDirectory() {
        dir.mkdir();
        assertTrue("Directory not found", dir.exists());
        assertTrue(dir.isDirectory());
        assertFalse(dir.isFile());
        dir.delete();
    }

    @Test
    public void testIsFile() {
        try {
            file.createNewFile();
        } catch (IOException ex) {
            fail("IOException");
        }
        assertTrue("File not found", file.exists());
        assertFalse(file.isDirectory());
        assertTrue(file.isFile());
        file.delete();
    }

    @Test
    public void testListFiles() {
        File parrentDir = new File("/home/dmitry/Thumbtack/practical-exercises-on-java-development/src");
        File[] files = parrentDir.listFiles();
        File[] files1 = {new File("/home/dmitry/Thumbtack/practical-exercises-on-java-development/src/test"),
                new File("/home/dmitry/Thumbtack/practical-exercises-on-java-development/src/main")};
        assertArrayEquals(files1, files);
    }

    @Test
    public void testListFilesFilter() {
        File parrentDir = new File("/home/dmitry/Thumbtack/practical-exercises-on-java-development");
        File[] files = parrentDir.listFiles((dir, name) -> name.endsWith(".iml"));
        File[] files1 = {new File("/home/dmitry/Thumbtack/practical-exercises-on-java-development/Thumbtack.iml")};
        assertArrayEquals(files1, files);
    }
}
