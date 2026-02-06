package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties prop = new Properties();
    private static volatile boolean isLoaded = false;

    private static void loadProperties() throws Exception {
        if (!isLoaded) {
            synchronized (ConfigReader.class) {
                if (!isLoaded) {
                    FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Config.properties");
                    prop.load(ip);
                    isLoaded = true;
                }
            }
        }
    }

    public static String getPropertyValueByKey(String key) throws Exception {
        loadProperties();
        String value = prop.getProperty(key);
        if (value == null || value.isEmpty()) {
            throw new Exception("value not specified for key: " + key);
        }
        return value;
    }
}
