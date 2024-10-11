package chapter_14.file_management_system.src.main.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Utility class for handling configuration properties.
 * <p>
 * This class provides methods to read configuration values from
 * properties files such as retrieving file paths or other configuration data.
 * It handles any IOExceptions that may occur while reading the config file
 * and throws a runtime exception for the caller to manage.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     String filePath = ConfigUtils.getFilePathFromConfig();
 * </pre>
 * </p>
 *
 * @author Obaid Ghafoori
 */
public class ConfigUtils {
    private static final String CONFIG_FILE_PATH = "ocp-java-17/src/resources/config.properties";
    private static final String basePath;

    static {
        basePath = loadBasePath();
    }

    /**
     * Loads the source file path from the config file.
     *
     * @return the source file path.
     */
    public static Path getSourceFilePath() {
        return Paths.get(loadSourcePath());
    }

    /**
     * Loads the destination file path from the config file.
     *
     * @return the destination file path.
     */
    public static Path getDestinationFilePath() {
        return Paths.get(loadTargetPath());
    }

    private static Path getDestinationFileAlternativePath() {
        return Paths.get(basePath, "destination.txt");
    }


    private static String getProperty(String key) {
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
            Properties prop = new Properties();
            prop.load(fis);
            return prop.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Error loading config file", e);
        }
    }

    private static String loadBasePath() {
        return getProperty("base.path");
    }

    private static String loadSourcePath() {
        return getProperty("source.file.path");
    }

    private static String loadTargetPath() {
        return getProperty("destination.file.path");
    }

}
