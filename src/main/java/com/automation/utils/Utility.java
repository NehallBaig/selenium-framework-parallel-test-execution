package com.automation.utils;

import com.automation.core.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

public class Utility {

    private static Properties prop;

    private static String screenshotPath;

    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

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

    public static void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    public static void clickButton(WebElement element){
        element.click();
    }

    public static void waitForSomeTime(int timeout){
        try{
            Thread.sleep(timeout* 1000L);
        }catch (Exception e){
           logger.error("Failed to wait: {}", e.getMessage());
        }
    }

    public static boolean waitForWebElementClickable(WebDriver driver, WebElement elements, int timeOuts) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOuts));
            wait.until(ExpectedConditions.elementToBeClickable(elements));
            return true;
        } catch (Exception e) {
            System.out.println("Element was not clickable within the specified timeout period");
            return false;
        }
    }

    public static boolean waitForWebElement(WebDriver driver, WebElement element, int timeOuts) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOuts));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            System.out.println("Element was not visible within the specified timeout period");
            return false;
        }
    }


    public synchronized static void takeScreenshot(String testName) throws IOException {
        File screenshotFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + "-" + dateTime() + ".png";
        File DestFile = new File(screenshotPath);
        FileUtils.copyFile(screenshotFile, DestFile);
    }

    private static String dateTime() {
        return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    }

    public static String getScreenshotPath() {
        return screenshotPath;
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
