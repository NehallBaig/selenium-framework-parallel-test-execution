package com.automation.pages;

import com.automation.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen extends AbstractScreen{

    @FindBy(className = "bm-burger-button")
    WebElement menuButton;

    @FindBy(linkText = "Logout")
    WebElement logout;

    public HomeScreen(WebDriver driver){
        super(driver);
    }

    private void clickMenuIcon(){
        Utility.clickButton(menuButton);
    }

    public void logout(){
        clickMenuIcon();
        Utility.waitForSomeTime(3);
        Utility.clickButton(logout);
    }
}
