package chapter_14.file_management_system.src.main.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static chapter_14.file_management_system.src.main.FileManager.createFileIfNotExists;

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

    /**
     * Appends content to a file while keeping a count of the number of appends.
     *
     * @param path    the path of the file.
     * @param content the content to append.
     * @throws IOException if an I/O error occurs.
     */
    public static void appendContentToFile(Path path, String content) throws IOException {
        createFileIfNotExists(path);

        int currentCount = getCurrentAppendCount(path);
        currentCount++;

        String formattedContent = String.format("Appending attempt [%d]: %s%s", currentCount, content, System.lineSeparator());

        Files.write(path, formattedContent.getBytes(), StandardOpenOption.APPEND);
        System.out.println("Content appended to file: " + path);
    }

    /**
     * Gets the current append count from the file.
     *
     * @param path the path of the file.
     * @return the current count of appends.
     * @throws IOException if an I/O error occurs.
     */
    private static int getCurrentAppendCount(Path path) throws IOException {
        if (Files.exists(path)) {
            var lines = Files.readAllLines(path);
            if (!lines.isEmpty()) {
                String lastLine = lines.get(lines.size() - 1);
                if (lastLine.startsWith("Appending attempt [")) {
                    return Integer.parseInt(lastLine.split("\\[")[1].split("\\]")[0]);
                }
            }
        }
        return 0;
    }
}

