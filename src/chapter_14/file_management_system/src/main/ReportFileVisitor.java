package chapter_14.file_management_system.src.main;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Custom file visitor to collect file information for the report.
 */
@AllArgsConstructor
class ReportFileVisitor extends SimpleFileVisitor<Path> {
    private final StringBuilder reportBuilder;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        String fileName = file.getFileName().toString();
        long fileSize = attrs.size();
        String creationTime = attrs.creationTime().toString();
        String lastModifiedTime = attrs.lastModifiedTime().toString();

        reportBuilder.append(String.format("%s,%d,%s,%s\n", fileName, fileSize, creationTime, lastModifiedTime));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException e) {
        System.err.println("Failed to access file: " + file + " due to " + e.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
