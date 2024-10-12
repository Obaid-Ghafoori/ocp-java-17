package chapter_14.file_management_system.src.main;

import chapter_14.file_management_system.src.main.utils.ConfigUtils;

import java.nio.file.Path;
import java.util.List;

import static chapter_14.file_management_system.src.main.utils.FileUtils.appendContentToFile;
import static chapter_14.file_management_system.src.main.utils.FileUtils.relativizeAndNormalizePath;

public class FileManagementSystem {
    public static void main(String[] args) {
        try {
            FileManager fileManager = new FileManager(List.of(new FileObserverImpl()));

            Path sourcePath = relativizeAndNormalizePath(ConfigUtils.getSourcePath("source.md").toString());
            Path destinationPath = relativizeAndNormalizePath(ConfigUtils.getDestinationPath("destination.md").toString());

            appendContentToFile(sourcePath, "This content is generated upon each program run!");

            fileManager.copyFile(sourcePath, destinationPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
