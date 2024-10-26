package chapter_14.file_management_system.src.main;

import chapter_14.file_management_system.src.main.utils.FileUtils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger logger = LoggerFactory.getLogger(FileManager.class.getName());

    public static void generateReportFrom(Path rootDirectory, Path fileSaveTo, String fileName, String fileExtension) {
        var reportGenerator = new FileReportGenerator(rootDirectory);
        var csvFile = new ReportType();

        try {
            FileUtils.createFileIfNotExists(fileSaveTo);

            var report = reportGenerator.generateReport(csvFile, fileSaveTo, fileName, fileExtension);
            logger.info("Generated Report:\n" + report);

            var reportFilePath = fileSaveTo.resolve(fileName + fileExtension);
            Files.writeString(reportFilePath, report);
            logger.info("Report saved to " + reportFilePath);

        } catch (IOException e) {
            logger.error("Error generating the report: " + e.getMessage());
        }
    }

    /**
     * Generates a report in the specified format and saves it to the destination.
     *
     * @param format      The report format implementation, defining how the report is saved.
     * @param destination The directory path where the report file will be saved.
     * @throws IOException if an I/O error occurs while generating or saving the report.
     */
    private String generateReport(ReportTypeFormatter format, Path destination, String fileName, String fileExtension) throws IOException {
        String content = generateReportContent();
        format.saveReport(content, destination, fileName, fileExtension);
        return content;

    }

    /**
     * Creates the report content by traversing the root directory.
     *
     * @return A string representation of the report in CSV format.
     * @throws IOException if an I/O error occurs during directory traversal.
     */
    private String generateReportContent() throws IOException {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("File Name,Size (bytes),Creation Time,Last Modified Time\n");
        FileVisitor<Path> fileVisitor = new ReportFileVisitor(reportBuilder);
        Files.walkFileTree(rootDirectory, fileVisitor);
        return reportBuilder.toString();
    }
}
