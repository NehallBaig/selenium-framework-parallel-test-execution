package com.automation.listeners;

import com.automation.core.DriverManager;
import com.automation.core.ExtentReportManager;
import com.automation.utils.Utility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Objects;

/**
 * This class implements the IInvokedMethodListener interface to provide custom behavior
 * after the invocation of test methods.
 */
public class InvokedMethodListener implements IInvokedMethodListener {

    /**
     * This method is invoked after the execution of a test method.
     *
     * @param method     The invoked method.
     * @param testResult The result of the test method execution.
     */
    public synchronized void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (!testResult.isSuccess()) {
            // Print separator line and failure message
            System.out.println("==============================================================");
            System.out.println("Failed " + testResult.getName());
            try {
                // Take a screenshot of the failed test
                Utility.takeScreenshot(testResult.getName());

                // Add the screenshot to the Extent report
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
