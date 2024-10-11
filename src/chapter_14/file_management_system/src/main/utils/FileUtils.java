package chapter_14.file_management_system.src.main.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utility class for handling file path operations.
 */
public class FileUtils {

    /**
     * Resolves a file name to a given directory.
     *
     * @param directory the base directory path
     * @param fileName  the name of the file to resolve
     * @return a {@link Path} representing the resolved file path
     */
    public static Path resolvePath(Path directory, String fileName) {
        return directory.resolve(fileName);
    }

    /**
     * Normalizes a given file path.
     *
     * @param path the file path to normalize
     * @return the normalized {@link Path}
     */
    public static Path normalizePath(Path path) {
        return path.normalize();
    }

    /**
     * Relativizes and normalizes the provided path string.
     * Converts the given path string to an absolute path, and normalizes it to remove any redundant elements.
     *
     * @param pathString The string representation of the path to be relativized and normalized.
     * @return The absolute and normalized Path object.
     */
    public static Path relativizeAndNormalizePath(String pathString) {
        return Paths.get(pathString).toAbsolutePath().normalize();
    }
}

