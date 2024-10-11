package chapter_14.file_management_system.src.main;

import chapter_14.file_management_system.src.main.utils.ConfigUtils;

import java.nio.file.Path;
import java.util.List;

import static chapter_14.file_management_system.src.main.utils.FileUtils.relativizeAndNormalizePath;

public class FileManagementSystem {
    public static void main(String[] args) {
        try {
            FileManager fileManager = new FileManager(List.of(new FileObserverImpl()));
            // ocp-java-17/src/chapter_14/file_management_system/src/resources
            Path sourcePath = relativizeAndNormalizePath(ConfigUtils.getFilePathFromConfig());
            Path destinationPath = relativizeAndNormalizePath(ConfigUtils.getFilePathFromConfig());

            fileManager.appendContentToFile(sourcePath, "This is new content of the file!");

            fileManager.copyFile(sourcePath, destinationPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
