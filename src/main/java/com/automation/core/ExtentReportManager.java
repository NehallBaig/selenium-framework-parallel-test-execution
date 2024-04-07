package com.automation.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ExtentReportManager {

    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);
    private static ExtentReports extentReport;
    private static ExtentTest extentTest;

    public static void setupReport(String testName) {
        extentReport = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/report/" +
                getExtentReportPrefixName(testName) + ".html");
        extentReport.attachReporter(spark);
    }

    private static String getExtentReportPrefixName(String testName) {
        String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        return testName + "-" + date;
    }

    public static void createTest(String testName, String description) {
        extentTest = extentReport.createTest(testName, description);
    }

    public static ExtentTest getTest() {
        try {
            return extentTest;
        } catch (NullPointerException e) {
            logger.error("Exception in getTest {}", e.getMessage());
        }
        return null;
    }

    public static void log(String message) {
        Objects.requireNonNull(getTest()).info(message);
    }

    public static void pass(String message) {
        Objects.requireNonNull(getTest()).pass(message);
    }

    public static void fail(String message) {
        Objects.requireNonNull(getTest()).fail(message);
    }

    public static void flushReport() {
        extentReport.flush();
    }
}
