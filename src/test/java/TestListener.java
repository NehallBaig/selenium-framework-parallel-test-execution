import com.automation.core.ExtentReportManager;
import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener {

    public synchronized void onStart(ISuite suite){
        System.out.println("=======================================================================");
        System.out.println(suite.getName()+" Suite started");
        ExtentReportManager.setupReport(suite.getName());
    }

    public synchronized void onTestStart(ITestResult result) {
        System.out.println("=======================================================================");
        System.out.println("Started "+result.getName());
        ExtentReportManager.createTest(result.getName(), "");
    }

    public synchronized void onFinish(ITestContext context) {
        System.out.println("=======================================================================");
        System.out.println("Finished "+context.getName());
        ExtentReportManager.flushReport();
    }
}
