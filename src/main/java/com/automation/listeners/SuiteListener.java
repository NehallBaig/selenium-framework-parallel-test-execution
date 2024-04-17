package com.automation.listeners;

import com.automation.core.DriverManager;
import com.automation.core.ExtentReportManager;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;

public class SuiteListener implements ISuiteListener {

    public synchronized void onStart(ISuite suite){
        System.out.println("=======================================================================");
        System.out.println(suite.getName()+" Suite started");
        ExtentReportManager.setupReport(suite.getName());
    }

}
