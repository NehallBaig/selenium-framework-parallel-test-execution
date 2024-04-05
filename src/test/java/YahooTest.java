import com.automation.core.DriverManager;
import com.automation.pages.HomeScreen;
import com.automation.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class YahooTest {

    @Test
    public void yahooTest() throws IOException {
        WebDriver driver= DriverManager.getDriver();

        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.navigateTo("https://yahoo.com");

        DriverManager.closeDriver();
    }
}