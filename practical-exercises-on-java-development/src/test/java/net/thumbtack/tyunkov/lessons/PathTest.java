package net.thumbtack.tyunkov.lessons;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 14.11.15.
 */
public class PathTest {

    @Test
    public void testPath() {
        Path path = Paths.get("demo.dat");
        try {
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertFalse(path.isAbsolute());
        assertTrue(path.toAbsolutePath().isAbsolute());
        assertEquals(Paths.get("/home/dmitry/Thumbtack/practical-exercises-on-java-development"), path.toAbsolutePath().getParent());
        assertEquals(Paths.get("/"), path.toAbsolutePath().getRoot());
        assertFalse(Files.exists(path));
        try {
            Files.createFile(path);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertTrue(Files.exists(path));
        assertFalse(Files.isExecutable(path));
        assertTrue(Files.isReadable(path));
        assertTrue(Files.isWritable(path));
        try {
            assertFalse(Files.isHidden(path));
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        Path pathCopy = Paths.get("demoCopy.dat");
        try {
            Files.deleteIfExists(pathCopy);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertFalse(Files.exists(pathCopy));
        try {
            Files.copy(path, pathCopy);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertTrue(Files.exists(pathCopy));
        try {
            assertTrue(Files.deleteIfExists(pathCopy));
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        try {
            assertTrue(Files.deleteIfExists(path));
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
    }
}
