import com.automation.core.ExtentReportManager;
import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener {

    public void onStart(ISuite suite){
        System.out.println("suite started "+suite.getName());
        ExtentReportManager.setupReport("ThreadLocalExtent"+suite.getName());
    }

    public void onTestStart(ITestResult result) {
        System.out.println("testname"+result.getName());

        ExtentReportManager.createTest(result.getName(), "");
//        System.out.println("test start"+result.getName());
      //  ExtentReportManager.setupReport(result.getName());
    }


    public void onFinish(ITestContext context) {

        System.out.println("test finish"+context.getName());
        ExtentReportManager.flushReport();
    }
//    public void onTestSuccess(ITestResult result) {
//        ExtentReportManager.flushReport();
//    }
}
