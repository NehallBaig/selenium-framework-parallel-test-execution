import com.automation.core.DriverManager;
import com.automation.core.PageObjectManager;
import com.automation.pages.HomeScreen;
import com.automation.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProjectManagerTest {
    private PageObjectManager pageObjectManager;

    @Test
    public void projectManagerTest() throws IOException {
        WebDriver driver= DriverManager.getDriver();

        pageObjectManager = new PageObjectManager(driver);
        HomeScreen homeScreen = pageObjectManager.getHomeScreen();

        homeScreen.navigateTo(Utility.getUrl());

        homeScreen.clickGmailLink();
        DriverManager.closeDriver();
    }
}
