package com.automation.listeners;

import com.automation.core.DriverManager;
import com.automation.core.ExtentReportManager;
import com.automation.utils.Utility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Objects;

public class InvokedMethodListener implements IInvokedMethodListener {

    public synchronized void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!testResult.isSuccess()) {
            System.out.println("==============================================================");
            System.out.println("Failed " + testResult.getName());
            try {
                Utility.takeScreenshot(testResult.getName());
                System.out.println(Utility.getScreenshotPath());
                Objects.requireNonNull(ExtentReportManager.getTest()).addScreenCaptureFromPath(Utility.getScreenshotPath());

                // Dynamic logging for failed scenario
                // In case of test failed, without handle failed log block
                Objects.requireNonNull(ExtentReportManager.getTest()).fail("Failed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                DriverManager.closeDriver();
            }
        }
    }
}
