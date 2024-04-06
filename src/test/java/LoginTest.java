import com.automation.core.DriverManager;
import com.automation.core.PageObjectManager;
import com.automation.data.LoginData;
import com.automation.pages.LoginScreen;
import com.automation.utils.Utility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
    public void multiLoginTest(String username, String password) throws IOException {
        PageObjectManager pageObjectManager = new PageObjectManager(DriverManager.getDriver());
        LoginScreen loginScreen = pageObjectManager.getLoginScreen();

        loginScreen.navigateTo(Utility.getUrl());
        Assert.assertTrue(loginScreen.login(username, password));
    }

    @Test(priority = 1, groups = "login", alwaysRun = true)
    public void loginTest() throws IOException {
        PageObjectManager pageObjectManager = new PageObjectManager(DriverManager.getDriver());
        LoginScreen loginScreen = pageObjectManager.getLoginScreen();

        loginScreen.navigateTo(Utility.getUrl());
        Assert.assertTrue(loginScreen.login("standard_user", "secret_sauce"));
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.closeDriver();
    }

}
