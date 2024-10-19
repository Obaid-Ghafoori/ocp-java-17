package chapter_14.file_management_system.src.main;

import chapter_14.file_management_system.src.main.utils.ConfigUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static chapter_14.file_management_system.src.main.utils.ConfigUtils.getTargetDirectoryPath;
import static chapter_14.file_management_system.src.main.utils.FileUtils.appendContentToFile;
import static chapter_14.file_management_system.src.main.utils.FileUtils.normalizeAbsolutePath;

public class FileManagementSystem {
    public static void main(String[] args) {
        try {
            FileManager fileManager = new FileManager(List.of(new FileObserverImpl()));

            Path sourcePath = normalizeAbsolutePath(ConfigUtils.getSourcePath("source.md").toString());
            Path destinationPath = normalizeAbsolutePath(ConfigUtils.getDestinationPath("destination.md").toString());

            appendContentToFile(sourcePath, "This content is generated upon each program run!");

            fileManager.copyFileTo(sourcePath, destinationPath);

            backupFileTo(fileManager, sourcePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void backupFileTo(FileManager fileManager, Path sourcePath) throws IOException {
        Path toBackupPath = getTargetDirectoryPath("backup");
        fileManager.backupFile(sourcePath, toBackupPath);
    }
}
