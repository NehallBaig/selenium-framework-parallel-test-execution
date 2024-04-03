package com.automation.utils;

import com.automation.core.DriverManager;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility {

    private static Properties prop;

    public static WebDriver getDriver() throws IOException {
        return DriverManager.getDriver();
    }

    public static String getUrl() throws IOException {
        try {
            return getPropertyValue("url");
        } catch (IOException e) {
            throw new IOException("Error getting URL: " + e.getMessage());
        }
    }

    public static String getPropertyValue(String key) throws IOException {
        try {
            return getProperties().getProperty(key);
        } catch (IOException e) {
            throw new IOException("Error getting property value: " + e.getMessage());
        }
    }


    public static Properties getProperties() throws IOException {
        try {
            prop = new Properties();
            FileInputStream data = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/resources/config.properties");
            prop.load(data);
            data.close();
        } catch (IOException e) {
            throw new IOException("Error loading properties file: " + e.getMessage());
        }

        return prop;
    }


}
