package chapter_14.file_management_system.src.main;

import chapter_14.file_management_system.src.main.utils.ConfigUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static chapter_14.file_management_system.src.main.FileReportGenerator.generateReportFrom;
import static chapter_14.file_management_system.src.main.utils.ConfigUtils.getTargetDirectoryPath;
import static chapter_14.file_management_system.src.main.utils.FileUtils.appendContentToFile;
import static chapter_14.file_management_system.src.main.utils.FileUtils.normalizeAbsolutePath;

public class FileManagementSystem {
    public static void main(String[] args) {
        Path sourcePath = normalizeAbsolutePath(ConfigUtils.getSourcePath("source.md").toString());
        Path destinationPath = normalizeAbsolutePath(ConfigUtils.getDestinationPath("destination.md").toString());

        try {
            FileManager fileManager = new FileManager(List.of(new FileObserverImpl()));
            appendContentToFile(sourcePath, "This content is generated upon each program run!");

            fileManager.copyFileTo(sourcePath, destinationPath);

            backupFileTo(fileManager, sourcePath);
            backupDirectoriesContents(fileManager);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Path rootDirectory = normalizeAbsolutePath("./ocp-java-17/src/chapter_14/");
        Path targetDirectory = normalizeAbsolutePath("./ocp-java-17/src/report-dir/");
        generateReportFrom(rootDirectory, targetDirectory, "tasking",".csv");
    }

    private static void backupDirectoriesContents(FileManager fileManager) throws IOException {
        Path sourceDir = normalizeAbsolutePath(ConfigUtils.getSourcePath("../").toString());
        Path backupDir = normalizeAbsolutePath(ConfigUtils.getSourcePath("../../backup-directories").toString());
        fileManager.backupDirectory(sourceDir, backupDir);
    }

    private static void backupFileTo(FileManager fileManager, Path sourcePath) throws IOException {
        Path toBackupPath = getTargetDirectoryPath("backup");
        fileManager.backupFile(sourcePath, toBackupPath);
    }



}
