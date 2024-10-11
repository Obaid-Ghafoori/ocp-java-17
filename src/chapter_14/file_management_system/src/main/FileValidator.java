package chapter_14.file_management_system.src.main;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

/**
 * Class for validating file properties and permissions.
 */
public class FileValidator {

    /**
     * Checks if the file exists.
     *
     * @param path the {@link Path} to check
     * @return true if the file exists, false otherwise
     */
    public static boolean fileExists(Path path) {
        return Files.exists(path);
    }

    /**
     * Checks if the file is readable.
     *
     * @param path the {@link Path} to check
     * @return true if the file is readable, false otherwise
     */
    public static boolean isReadable(Path path) {
        return Files.isReadable(path);
    }

    /**
     * Checks if the file is writable.
     *
     * @param path the {@link Path} to check
     * @return true if the file is writable, false otherwise
     */
    public static boolean isWritable(Path path) {
        return Files.isWritable(path);
    }

    /**
     * Validates if the file can be processed (exists, readable, and writable).
     *
     * @param path the {@link Path} to validate
     * @throws IOException if the file does not meet the conditions
     */
    public static void validateFile(Path path) throws IOException {
        if (!fileExists(path)) {
            throw new IOException("File does not exist: " + path);
        }

        if (!isReadable(path)) {
            throw new IOException("File is not readable: " + path);
        }

        if (!isWritable(path)) {
            throw new IOException("File is not writable: " + path);
        }
    }
}
