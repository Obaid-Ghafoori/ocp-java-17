package chapter_14.file_management_system.src.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for managing file operations like copy, move, and delete.
 */
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

    public void copyFile(Path source, Path destination) throws IOException{
        FileValidator.validateFile(source);
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        System.out.println(String.format("File copied from: %s to %s", source, destination));
        notifyObservers("copy", destination);

    }

    private void notifyObservers(String operation, Path filePath){
        for(FileObserver observer : observers){
            observer.onFileEvent(operation, filePath);
        }
    }
}
