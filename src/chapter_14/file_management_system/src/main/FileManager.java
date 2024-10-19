package chapter_14.file_management_system.src.main;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static chapter_14.file_management_system.src.main.utils.FileUtils.createDirectoriesAt;
import static chapter_14.file_management_system.src.main.utils.FileUtils.resolvePath;

/**
 * Class responsible for managing file operations like copy, move, and delete.
 */
@AllArgsConstructor
@NoArgsConstructor
public class FileManager {
    private static final Logger logger = LoggerFactory.getLogger(FileManager.class.getName());
    private List<FileObserver> observers;

    public void addObserver(FileObserver observer) {
        if (observer != null) {
            observers = new ArrayList<>();
        }
        observers.add(observer);
    }

    /**
     * Copies a file from source to destination.
     *
     * @param source      the source file path
     * @param destination the destination file path
     * @throws IOException if the file cannot be copied
     */

    public void validateAndCopyFile(Path source, Path destination) throws IOException {
        FileValidator.validateFile(source);
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
    }

    /**
     * Moves a file from source to destination.
     *
     * @param source      the source file path
     * @param destination the destination file path
     * @throws IOException if the file cannot be moved
     */

    public void moveFile(Path source, Path destination) throws IOException {
        FileValidator.validateFile(source);
        Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        logger.info("File moved from " + source + " to " + destination);
        notifyObservers("MOVE", destination);
    }

    /**
     * Deletes a file.
     *
     * @param path the file path to delete
     * @throws IOException if the file cannot be deleted
     */
    public void deleteFile(Path path) throws IOException {
        FileValidator.validateFile(path);
        Files.deleteIfExists(path);
        logger.info("File deleted: " + path);
        notifyObservers("DELETE", path);
    }

    /**
     * Copies a file from the source path to the destination path using the specified FileManager.
     * The destination file is overwritten if it already exists.
     *
     * @param sourcePath      The source file path.
     * @param destinationPath The destination file path where the file is to be copied.
     * @throws IOException If an I/O error occurs during the file copy operation.
     */
    public void copyFileTo(Path sourcePath, Path destinationPath) throws IOException {
        logger.info("Validating and copying file...");
        validateAndCopyFile(sourcePath, destinationPath);
        notifyObservers("COPY", destinationPath);
        logger.info("File copied from " + sourcePath + " to " + destinationPath);
    }

    /**
     * Backs up a single file to the specified backup directory.
     *
     * @param sourcePath      The path of the file to back up.
     * @param backupDirectory The directory where the file will be backed up.
     * @throws IOException If an I/O error occurs during the backup process.
     */
    public void backupFile(Path sourcePath, Path backupDirectory) throws IOException {
        createDirectoriesAt(backupDirectory);

        var toBackupPath = resolvePath(backupDirectory, sourcePath.getFileName().toString());

        copyFileTo(sourcePath, toBackupPath);
    }

    /**
     * Backs up all files in a specified directory to a backup directory.
     *
     * @param sourceDirectory The directory to back up.
     * @param backupDirectory The directory where files will be backed up.
     * @throws IOException If an I/O error occurs during the backup process.
     */
    public void backupDirectory(Path sourceDirectory, Path backupDirectory) throws IOException {
        Files.walk(sourceDirectory).forEach(sourcePath -> {
            try {
                Path targetPath = backupDirectory.resolve(sourceDirectory.relativize(sourcePath));
                if (Files.isDirectory(sourcePath)) {
                    Files.createDirectories(targetPath);
                } else {
                    validateAndCopyFile(sourcePath, targetPath);
                    logger.info("File backed up: " + sourcePath + " to " + targetPath);
                }
            } catch (IOException e) {
                logger.error("Failed to back up: " + sourcePath + " due to " + e.getMessage());
            }
        });

    }

    private void notifyObservers(String operation, Path filePath) {
        for (FileObserver observer : observers) {
            observer.onFileEvent(operation, filePath);
        }
    }

}
