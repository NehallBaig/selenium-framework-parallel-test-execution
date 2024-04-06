package com.automation.pages;

import com.automation.core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.automation.utils.Utility.clickButton;
import static com.automation.utils.Utility.enterText;

public class LoginScreen extends AbstractScreen {

    private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);


    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginScreen(WebDriver driver){
        super(driver);
    }

    private void enterUsername(String username){
        enterText(usernameField,username);
    }

    private void enterPassword(String password){
        enterText(passwordField,password);
    }

    private void clickLoginBtn(){
        clickButton(loginButton);
    }

    public boolean login(String username, String password){
        try{
            enterUsername(username);
            enterPassword(password);
            clickLoginBtn();

            return true;
        }catch (Exception e){
            logger.error("Error occurred while login: {}", e.getMessage());
            return false;
        }
    }

}
