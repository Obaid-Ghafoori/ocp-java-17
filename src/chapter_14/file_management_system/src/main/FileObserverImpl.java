package chapter_14.file_management_system.src.main;

import java.nio.file.Path;

/**
 * Implementation of the {@link FileObserver} interface.
 * Logs file operations to the console.
 */
public class FileObserverImpl implements FileObserver {
    /**
     * Called when a file operation occurs.
     *
     * @param operation the type of operation (copy, move, delete)
     * @param filePath  the path of the file involved in the operation
     */
    @Override
    public void onFileEvent(String operation, Path filePath) {
        System.out.println(String.format("File operation: %s on file %s", operation, filePath));
    }
}
