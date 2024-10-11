package chapter_14.file_management_system.src.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileManagementSystem {
    public static void main(String[] args) {
        try {
            FileManager fileManager = new FileManager(List.of(new FileObserverImpl()));

            Path sourcePath = relativizeAndNormalizePath("src/main/resources/source.txt");
            Path destinationPath = relativizeAndNormalizePath("src/main/resources/destination.txt");

            appendContentToFile(sourcePath,"This is main content of the file!");

            copyFile(fileManager, sourcePath, destinationPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Path relativizeAndNormalizePath(String pathString) {
        return Paths.get(pathString).toAbsolutePath().normalize();
    }

    private static void createFileIfNotExists(Path path) throws IOException {
        createParentDirectories(path);

        if (Files.notExists(path)) {
            Files.createFile(path);
            System.out.println("File created: " + path);
        } else {
            System.out.println("File already exists: " + path);
        }
    }

    private static void createParentDirectories(Path path) throws IOException {
        Files.createDirectories(path.getParent());
        System.out.println("parent-path:" + path.getParent());
    }

    private static void appendContentToFile(Path path, String content) throws IOException {
        createFileIfNotExists(path);

        if (Files.exists(path) && !Files.isDirectory(path)) {
            Files.write(path, (content + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            System.out.println("Content appended to file: " + path);
        } else {
            System.out.println("File does not exist or is a directory: " + path);
        }
    }

    private static void copyFile(FileManager fileManager, Path sourcePath, Path destinationPath) throws IOException {
        fileManager.copyFile(sourcePath, destinationPath);
        System.out.println("File copied from " + sourcePath + " to " + destinationPath);
    }
}
