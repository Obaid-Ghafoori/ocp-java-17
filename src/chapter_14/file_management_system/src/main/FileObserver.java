package chapter_14.file_management_system.src.main;

import java.nio.file.Path;

/**
 * Interface for observing file management operations.
 */
public interface FileObserver {

    /**
     * Called when a file operation occurs.
     *
     * @param operation  the type of operation (copy, move, delete)
     * @param filePath   the path of the file involved in the operation
     */
    void onFileEvent(String operation, Path filePath);
}
