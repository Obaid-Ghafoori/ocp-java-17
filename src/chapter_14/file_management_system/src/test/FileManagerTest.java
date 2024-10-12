package chapter_14.file_management_system.src.test;

import chapter_14.file_management_system.src.main.FileManager;
import chapter_14.file_management_system.src.main.FileObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FileManagerTest {

    private FileManager fileManager;

    @Mock
    private FileObserver fileObserverMock;

    @Mock
    private Logger logger;


    @BeforeEach
    public void setUp() {
        Mockito.mockStatic(Logger.class);
        Mockito.when(Logger.getLogger(FileManager.class.getName())).thenReturn(logger);
        fileManager = new FileManager(List.of(fileObserverMock));
    }

    @Test
    @DisplayName("file copy successfully when copyFile operation is invoked")
    void copyFileSuccessfullyWhenCopyFileOperationInvoked() throws IOException {
        Path source = Paths.get("source.txt");
        Files.createFile(source);
        Path destination = Paths.get("destination.txt");

        fileManager.copyFile(source, destination);

        assertThat(source.toFile().getName()).isEqualTo("source.txt");

        Files.deleteIfExists(source);

        verify(fileObserverMock).onFileEvent("copy".toUpperCase(), destination);
        verify(logger).info("File copied from " + source + " to " + destination);

    }
}
