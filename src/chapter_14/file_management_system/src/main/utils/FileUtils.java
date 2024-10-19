package chapter_14.file_management_system.src.main.utils;

import chapter_14.file_management_system.src.main.FileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * Utility class for handling file path operations.
 */
public class FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileManager.class.getName());

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
    public static Path normalizeAbsolutePath(String pathString) {
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
        logger.info("Content appended to file: " + path);
    }

    /**
     * Creates file in the given path
     *
     * @param path the path of the file.
     * @throws IOException if an I/O error occurs.
     */
    public static void createFileIfNotExists(Path path) throws IOException {
        createParentDirectories(path);

        if (Files.notExists(path)) {
            Files.createFile(path);
            logger.info("File created: " + path);
        } else {
            logger.warn("File already exists: " + path);
        }
    }

    /**
     * Create directories at the given path
     *
     * @param path the path of the file.
     * @throws IOException if an I/O error occurs.
     */

    public static void createDirectoriesAt(Path path) throws IOException {
        Files.createDirectories(path);
        logger.info("Directories created: " + path);
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

    private static void createParentDirectories(Path path) throws IOException {
        Files.createDirectories(path.getParent());
        logger.info("Parent directories created: " + path.getParent());
    }
}

