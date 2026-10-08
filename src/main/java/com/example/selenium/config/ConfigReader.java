package com.example.selenium.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.err.println("Không tìm thấy file config.properties, sẽ sử dụng giá trị mặc định.");
            } else {
                properties.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String val = properties.getProperty(key);
        return val != null ? Boolean.parseBoolean(val) : defaultValue;
    }

    public static int getInt(String key, int defaultValue) {
        String val = properties.getProperty(key);
        try {
            return val != null ? Integer.parseInt(val) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
