package chapter_14.file_management_system.src.main;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
class ReportFileVisitor extends SimpleFileVisitor<Path> {
    private final StringBuilder reportBuilder;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        String fileName = file.getFileName().toString();
        long fileSize = attrs.size();

        String creationTime = getCreationTime(attrs);
        String lastModifiedTime = getLastModifiedTime(attrs);

        reportBuilder.append(String.format("%s,\t%d,\t%s,\t%s\n", fileName, fileSize, creationTime, lastModifiedTime));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException e) {
        System.err.println("Failed to access file: " + file + " due to " + e.getMessage());
        return FileVisitResult.CONTINUE;
    }

    private static String getCreationTime(BasicFileAttributes attrs) {
        return ZonedDateTime.ofInstant(attrs.creationTime().toInstant(), ZoneId.systemDefault())
                .format(formatter);
    }

    private static String getLastModifiedTime(BasicFileAttributes attrs) {
        return ZonedDateTime.ofInstant(attrs.lastModifiedTime().toInstant(), ZoneId.systemDefault())
                .format(formatter);
    }
}

