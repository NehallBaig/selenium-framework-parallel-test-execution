import com.automation.core.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        ExtentReportManager.setupReport(result.getName());
    }

    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
    }
}
