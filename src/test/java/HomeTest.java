import com.automation.core.DriverManager;
import com.automation.core.PageObjectManager;
import com.automation.pages.HomeScreen;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeTest {

    private HomeScreen homeScreen;
    private LoginTest loginTest;

    @Test(priority = 2, groups="homeLogout", dependsOnGroups = "login")
    public void logoutTest() throws IOException {
        loginTest = new LoginTest();
        loginTest.loginTest();

        PageObjectManager pageObjectManager = new PageObjectManager(DriverManager.getDriver());
        homeScreen = pageObjectManager.getHomeScreen();
        homeScreen.logout();

        DriverManager.closeDriver();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.closeDriver();
    }
}
