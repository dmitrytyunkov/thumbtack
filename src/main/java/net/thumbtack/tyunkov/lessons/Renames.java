package net.thumbtack.tyunkov.lessons;

// REVU what is it ?
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.regex.Pattern;

/**
 * Created by dmitry on 14.11.15.
 */
public class Renames {
    public static void rename(String pathString, String sourceFilter, String receiverFilter) {
        Path path = Paths.get(pathString);
        try (DirectoryStream<Path> pathDirectoryStream = Files.newDirectoryStream(path, sourceFilter)) {
            for (Path pathSource : pathDirectoryStream) {
                Path pathReceiver = Paths.get(pathSource.toString().replaceAll("\\" + sourceFilter.substring(1) + "$", receiverFilter.substring(1)));
                Files.move(pathSource, pathReceiver);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
