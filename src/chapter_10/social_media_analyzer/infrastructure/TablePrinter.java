package chapter_10.social_media_analyzer.infrastructure;

import java.util.List;
import java.util.function.Function;

public class TablePrinter {
    /**
     * Returns the format string and header for a table based on the data type.
     *
     * @param dataType the type of data to be displayed in the table
     * @return an array where the first element is the format string and the second element is the header array
     */
    public static Object[] getTableFormatAndHeader(String dataType) {
        switch (dataType) {
            case "User":
                return new Object[]{
                        "%-10s %-20s %-25s %-10s %-10s %-10s %10s",
                        new String[]{"User ID", "Username", "Email", "Posts", "Comments", "Likes", "Shares"}
                };
            case "UserEngagement":
                return new Object[]{
                        "%-25s %-20s %30s",
                        new String[]{"Username", "Engagement Score", "Total Activities"}
                };
            default:
                throw new IllegalArgumentException("Unsupported data type: " + dataType);
        }
    }
    /**
     * Prints a table with the given data, format, and header.
     *
     * @param data      the list of data to be printed
     * @param title     the title of the table
     * @param extractor a function to extract the data for each row
     * @param dataType  the type of data to determine the format and header
     */
    public static <T> void printTable(List<T> data, String title, Function<T, Object[]> extractor, String dataType) {
        // Get the format and header for the table
        Object[] formatAndHeader = getTableFormatAndHeader(dataType);
        String format = (String) formatAndHeader[0];
        String[] header = (String[]) formatAndHeader[1];

        // Define the table width based on the format string
        int tableWidth = String.format(format, header).length();

        // Center the title
        int titlePadding = (tableWidth - title.length()) / 2;
        String centeredTitle = String.format("%" + titlePadding + "s%s", "", title.toUpperCase());

        // Print the centered title and the table
        System.out.println("\n" + centeredTitle);
        System.out.println(String.format(format, (Object[]) header));
        System.out.println("-".repeat(tableWidth));

        // Print the rows
        for (T item : data) {
            System.out.println(String.format(format, extractor.apply(item)));
        }
        System.out.println("-".repeat(tableWidth));
    }
}
