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
    private Path source;
    private Path destination;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        fileManager = new FileManager(List.of(fileObserverMock));
        source = Paths.get("source.txt");
        destination = Paths.get("destination.txt");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Paths.get("source.txt"));
        Files.deleteIfExists(Paths.get("destination.txt"));
    }

    @Test
    @DisplayName("copy file perform copy operations successfully when source file exists")
    void copyFilePerformCopyOperationSuccessfullyWhenSourceFileExists() throws IOException {
        Files.createFile(source);
        fileManager.copyFileTo(source, destination);

        assertThat(source.toFile().getName()).isEqualTo("source.txt");

        verify(fileObserverMock).onFileEvent("copy".toUpperCase(), destination);
    }

    @Test
    @DisplayName("Copy file throws exception when source file does not exist")
    void copyFileThrowsExceptionWhenSourceFileNotExists() {
        assertThatThrownBy(() -> fileManager.validateAndCopyFile(source, destination))
                .isInstanceOf(IOException.class)
                .hasMessage("File does not exist: " + source);
    }

    @Test
    @DisplayName("Move file moves file when source file does not exist")
    void moveFileMovesFileWhenSourceFileNotExists() throws IOException {
        Files.createFile(source);
        fileManager.moveFile(source, destination);

        assertThat(destination.toFile().getName()).isEqualTo("destination.txt");

        verify(fileObserverMock).onFileEvent("move".toUpperCase(), destination);
    }

    @Test
    @DisplayName("Delete file deletes file when given file exists")
    void deleteFileDeletesFileWhenGivenFileExists() throws IOException {
        Files.createFile(source);
        fileManager.deleteFile(source);

        assertThat(Files.exists(source)).isFalse();
        verify(fileObserverMock).onFileEvent("delete".toUpperCase(), source);
    }

    @Test
    @DisplayName("Delete file throws exception when source file does not exist")
    void deleteFileThrowsExceptionWhenSourceFileNotExists() {

        assertThatThrownBy(() -> fileManager.deleteFile(source))
                .isInstanceOf(IOException.class)
                .hasMessage("File does not exist: " + source);
    }

    @Test
    @DisplayName("should not back up when source directory is empty")
    void shouldNotBackupWhenSourceDirectoryIsEmpty() throws IOException {
        Path backupDirectory = Files.createTempDirectory("backupPath");
        Path sourceDirectory = Files.createTempDirectory("sourcePath");
        Path emptySourceDir = Files.createTempDirectory("emptySourceDir");

        fileManager.backupDirectory(sourceDirectory, backupDirectory);

        assertThat(backupDirectory).isEmptyDirectory();
        Files.deleteIfExists(emptySourceDir);
    }

    @Test
    @DisplayName("Should throw IOException when backing up a non-existent source directory")
    void shouldThrowIOExceptionWhenBackingUpNonExistentSourceDirectory() throws IOException {
        Path backupDirectory = Files.createTempDirectory("backupPath");
        Path invalidSourceDir = Paths.get("nonExistentDirectory");

        assertThatThrownBy(() -> fileManager.backupDirectory(invalidSourceDir, backupDirectory))
                .isInstanceOf(IOException.class)
                .hasMessageContaining("nonExistentDirectory");
    }
}
