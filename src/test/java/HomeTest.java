import com.automation.core.DriverManager;
import com.automation.core.ExtentReportManager;
import com.automation.core.PageObjectManager;
import com.automation.pages.HomeScreen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeTest {

    private HomeScreen homeScreen;
    private LoginTest loginTest;

    @Test(priority = 100)//, dependsOnGroups = "login", groups="homeLogout"
    public void logoutTest() throws IOException {
        loginTest = new LoginTest();
        loginTest.loginTest();

        PageObjectManager pageObjectManager = new PageObjectManager(DriverManager.getDriver());
        homeScreen = pageObjectManager.getHomeScreen();
        homeScreen.logout();

        ExtentReportManager.pass("Successfully logout");
        DriverManager.closeDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.closeDriver();
    }
}
