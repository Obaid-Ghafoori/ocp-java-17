package chapter_14.file_management_system.src.test;

import chapter_14.file_management_system.src.main.FileManager;
import chapter_14.file_management_system.src.main.FileObserver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FileManagerTest {

    private FileManager fileManager;
    @Mock
    private FileObserver fileObserverMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        fileManager = new FileManager(List.of(fileObserverMock));

    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get("source.txt"));
        Files.deleteIfExists(Paths.get("destination.txt"));
    }

    @Test
    @DisplayName("copy file perform copy operations successfully when source file exists")
    void copyFilePerformCopyOperationSuccessfullyWhenSourceFileExists() throws IOException {
        Path source = Paths.get("source.txt");
        Files.createFile(source);
        Path destination = Paths.get("destination.txt");

        fileManager.copyFile(source, destination);

        assertThat(source.toFile().getName()).isEqualTo("source.txt");

        verify(fileObserverMock).onFileEvent("copy".toUpperCase(), destination);
    }

    @Test
    @DisplayName("Copy file throws exception when source file does not exist")
    void copyFileThrowsExceptionWhenSourceFileNotExists() {
        // Given
        Path source = Paths.get("source.txt");
        Path destination = Paths.get("destination.txt");

        // When & Then
        assertThatThrownBy(() -> fileManager.validateAndCopyFile(source, destination))
                .isInstanceOf(IOException.class)
                .hasMessage("File does not exist: " + source);
    }
}
