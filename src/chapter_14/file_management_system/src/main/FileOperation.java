package chapter_14.file_management_system.src.main;

import java.io.IOException;
import java.nio.file.Path;

public interface FileOperation {

    void execute(Path source, Path target) throws IOException;
}
