package com.automation.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class implements the TestNG IRetryAnalyzer interface to provide custom retry behavior for failed tests.
 *
 * Purpose of RetryAnalyzer:
 * - TestNG's retry functionality allows rerunning failed tests a specified number of times.
 * - This class, RetryAnalyzer, implements the retry logic for failed tests.
 *
 * How RetryAnalyzer Works:
 * - When a test fails, TestNG invokes the retry method of RetryAnalyzer.
 * - The retry method determines whether to retry the failed test based on a retry limit.
 * - In this implementation, the retry limit is set to 2, meaning a failed test will be retried twice.
 * - The counter variable keeps track of the number of retry attempts.
 * - If the counter is less than the retry limit, the method returns true, indicating that the test should be retried.
 * - Once the counter reaches the retry limit, the method returns false, indicating that the test should not be retried further.
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private static int counter = 0;
    private static final int retryLimit = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }

    public static int getTestCount(){
        return counter;
    }
}
