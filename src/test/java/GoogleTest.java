import com.automation.core.DriverManager;
import com.automation.pages.HomeScreen;
import com.automation.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoogleTest {

    @Test
    public void homeScreenTest() throws IOException {
        WebDriver driver= DriverManager.getDriver();

        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.navigateTo(Utility.getUrl());

        homeScreen.clickGmailLink();
        DriverManager.closeDriver();
    }
}
