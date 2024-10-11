package chapter_14.file_management_system.src.main.utils;

import java.io.FileInputStream;
import java.io.IOException;
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
 * @author Obaid Ghafoori
 */
public class ConfigUtils {
    /**
     * Retrieves the file path from the configuration properties file.
     *
     * @return The file path specified in the config file.
     * @throws RuntimeException If there is an issue loading the config file.
     */

    public static String getFilePathFromConfig() {
        String configFilePath = "ocp-java-17/src/resources/config.properties";

        try (FileInputStream fis = new FileInputStream(configFilePath)) {
            Properties prop = new Properties();
            prop.load(fis);
            return prop.getProperty("file.path");
        } catch (IOException e) {
            throw new RuntimeException("Error loading config file", e);
        }
    }

}
