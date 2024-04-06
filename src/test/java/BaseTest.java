import com.automation.core.DriverManager;
import com.automation.core.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {

    private PageObjectManager pageObjectManager;
    protected WebDriver driver;

    public void contextSetup() throws IOException {
        driver= DriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
    }

    @BeforeMethod
    public void setupTest() throws IOException {
        contextSetup();
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }

    @AfterMethod
    public void tearDown(){
       DriverManager.closeDriver();
    }

}
