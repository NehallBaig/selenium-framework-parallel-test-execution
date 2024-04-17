package com.automation.listeners;

import com.automation.core.DriverManager;
import com.automation.core.ExtentReportManager;
import com.automation.utils.Utility;
import org.testng.*;

import java.io.IOException;
import java.util.Objects;

public class TestListener implements ITestListener {

    public synchronized void onTestStart(ITestResult result) {
        System.out.println("=======================================================================");
        System.out.println("Started "+result.getName());
        ExtentReportManager.createTest(result.getName(), "");
    }

    public synchronized void onFinish(ITestContext context) {
        System.out.println("=======================================================================");
        System.out.println("Finished "+context.getName());
        ExtentReportManager.flushReport();
        DriverManager.closeDriver();
    }
}
