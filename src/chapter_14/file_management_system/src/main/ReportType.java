package chapter_14.file_management_system.src.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportType implements ReportTypeFormatter{
    /**
     * Saves the report content in CSV format at the specified destination.
     *
     * @param content     The report content to save in CSV format.
     * @param destination The directory path where the CSV file will be saved.
     * @throws IOException if an I/O error occurs while saving the CSV report.
     */
    @Override
    public void saveReport(String content, Path destination, String fileName, String fileExtension) throws IOException {
        Files.writeString(destination.resolve(fileName + fileExtension), content);
    }
}
