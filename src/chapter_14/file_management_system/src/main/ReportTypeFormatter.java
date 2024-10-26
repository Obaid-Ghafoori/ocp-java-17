package chapter_14.file_management_system.src.main;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Interface for saving reports in various formats.
 * Each implementation of this interface will define a specific format such as CSV, TXT, PDF, etc.
 */
public interface ReportTypeFormatter {

    /**
     * Saves the given report content to the specified destination in the format defined by the implementation.
     *
     * @param content     The content of the report to save.
     * @param destination The directory path where the report will be saved.
     * @throws IOException if an I/O error occurs while saving the report.
     */
    void saveReport(String content, Path destination, String fileName, String fileExtension) throws IOException;
}
