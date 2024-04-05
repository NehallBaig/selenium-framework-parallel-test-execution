import com.automation.core.DriverManager;
import com.automation.pages.HomeScreen;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class FacebookTest {

    @Test
    public void facebookTest() throws IOException {
        WebDriver driver= DriverManager.getDriver();

        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.navigateTo("https://www.facebook.com");

        DriverManager.closeDriver();
    }
}
