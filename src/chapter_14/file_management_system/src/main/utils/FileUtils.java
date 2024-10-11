package chapter_14.file_management_system.src.main.utils;

import java.nio.file.Path;

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
}

