package chapter_14.file_management_system.src.main;

import java.nio.file.Path;
import java.util.logging.Logger;

/**
 * Implementation of the {@link FileObserver} interface.
 * Logs file operations to the console.
 */
public class FileObserverImpl implements FileObserver {
    private static final Logger logger = Logger.getLogger(FileObserverImpl.class.getName());
    /**
     * Called when a file operation occurs.
     *
     * @param operation the type of operation (copy, move, delete)
     * @param filePath  the path of the file involved in the operation
     */
    @Override
    public void onFileEvent(String operation, Path filePath) {
        logger.info(String.format("File copied from %s to %s", operation, filePath));

    }
}
