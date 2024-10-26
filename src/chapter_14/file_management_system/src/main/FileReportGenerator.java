package chapter_14.file_management_system.src.main;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Main class to generate a file report from a specified directory.
 */
@AllArgsConstructor
public class FileReportGenerator {

    private final Path rootDirectory;

    /**
     * Generates a report of files in the specified directory.
     *
     * @return A string containing the report in CSV format.
     * @throws IOException If an I/O error occurs.
     */
    public String generateReport() throws IOException {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("File Name,\tSize (bytes),\tCreation \tTime,\tLast Modified Time\n");

        FileVisitor<Path> fileVisitor = new ReportFileVisitor(reportBuilder);
        Files.walkFileTree(rootDirectory, fileVisitor);

        return reportBuilder.toString();
    }
}
