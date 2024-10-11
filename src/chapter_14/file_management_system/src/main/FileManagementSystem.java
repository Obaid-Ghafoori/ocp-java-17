package chapter_14.file_management_system.src.main;

import java.nio.file.Path;
import java.util.List;

import static chapter_14.file_management_system.src.main.utils.FileUtils.relativizeAndNormalizePath;

public class FileManagementSystem {
    public static void main(String[] args) {
        try {
            FileManager fileManager = new FileManager(List.of(new FileObserverImpl()));

            Path sourcePath = relativizeAndNormalizePath("src/main/resources/source.txt");
            Path destinationPath = relativizeAndNormalizePath("src/main/resources/destination.txt");

            fileManager.appendContentToFile(sourcePath, "This is new content of the file!");

            fileManager.copyFile(sourcePath, destinationPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
