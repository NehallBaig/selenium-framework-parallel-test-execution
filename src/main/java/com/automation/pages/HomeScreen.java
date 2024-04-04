package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen extends AbstractScreen{

    @FindBy(className = "gb_H")
    WebElement gmailLink;

    public HomeScreen(WebDriver driver){
        super(driver);
    }

    public void clickGmailLink()
    {
        gmailLink.click();
    }

}
