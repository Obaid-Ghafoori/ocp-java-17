package chapter_14.file_management_system.src.main;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for managing file operations like copy, move, and delete.
 */
@AllArgsConstructor
@NoArgsConstructor
public class FileManager {

    private List<FileObserver> observers;


    public void addObserver(FileObserver observer){
        if(observer != null){
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

    public void validateAndCopyFile(Path source, Path destination) throws IOException{
        FileValidator.validateFile(source);
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(String.format("File copied from: %s to %s", source, destination));
        notifyObservers("COPY", destination);

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
        System.out.println("File moved from " + source + " to " + destination);
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
        System.out.println("File deleted: " + path);
        notifyObservers("DELETE", path);
    }

    /**
     * Copies a file from the source path to the destination path using the specified FileManager.
     * The destination file is overwritten if it already exists.
     *
     * @param sourcePath The source file path.
     * @param destinationPath The destination file path where the file is to be copied.
     * @throws IOException If an I/O error occurs during the file copy operation.
     */
    public void copyFile(Path sourcePath, Path destinationPath) throws IOException {
        validateAndCopyFile(sourcePath, destinationPath);
        System.out.println("File copied from " + sourcePath + " to " + destinationPath);
    }


    private void notifyObservers(String operation, Path filePath){
        for(FileObserver observer : observers){
            observer.onFileEvent(operation, filePath);
        }
    }

    public static void createFileIfNotExists(Path path) throws IOException {
        createParentDirectories(path);

        if (Files.notExists(path)) {
            Files.createFile(path);
            System.out.println("File created: " + path);
        } else {
            System.out.println("File already exists: " + path);
        }
    }

    private static void createParentDirectories(Path path) throws IOException {
        Files.createDirectories(path.getParent());
        System.out.println("Parent directories created: " + path.getParent());
    }
}
