package net.thumbtack.tyunkov.lessons;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by dmitry on 14.11.15.
 */
public class RenamesTest {

    @Test
    public void testRename() {
        String pathString = "/home/dmitry/Thumbtack", sourceFilter = "*.bin", receiverFilter = "*.dat";
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        Path path = Paths.get(pathString);
        try (DirectoryStream<Path> pathDirectoryStream = Files.newDirectoryStream(path, sourceFilter)) {
            for (Path p : pathDirectoryStream)
                count++;
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        try (DirectoryStream<Path> pathDirectoryStream = Files.newDirectoryStream(path, receiverFilter)) {
            for (Path p : pathDirectoryStream)
                count++;
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        Renames.rename(pathString, sourceFilter, receiverFilter);
        try (DirectoryStream<Path> pathDirectoryStream = Files.newDirectoryStream(path, sourceFilter)) {
            for (Path p : pathDirectoryStream)
                count1++;
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        try (DirectoryStream<Path> pathDirectoryStream = Files.newDirectoryStream(path, receiverFilter)) {
            for (Path p : pathDirectoryStream)
                count2++;
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
        assertEquals(0, count1);
        assertEquals(count, count2);
    }
}