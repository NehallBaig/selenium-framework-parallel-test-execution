import com.automation.core.DriverManager;
import com.automation.pages.HomeScreen;
import com.automation.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class GitHubTest {

    @Test
    public void gitHubTest() throws IOException {
        WebDriver driver= DriverManager.getDriver();

        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.navigateTo("https://github.com/");

        DriverManager.closeDriver();
    }
}
