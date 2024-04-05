package com.automation.core;

import com.automation.pages.HomeScreen;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private HomeScreen homeScreen;
    private final WebDriver driver;


    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }


    public HomeScreen getHomeScreen (){
        return homeScreen == null ? homeScreen = new HomeScreen(driver) : homeScreen;
    }



}
