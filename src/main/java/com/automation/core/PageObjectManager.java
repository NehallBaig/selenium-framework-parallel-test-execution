package com.automation.core;

import com.automation.pages.HomeScreen;
import com.automation.pages.ProductsScreen;
import com.automation.pages.LoginScreen;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private HomeScreen homeScreen;
    private ProductsScreen productScreen;
    private LoginScreen loginScreen;

    private final WebDriver driver;


    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }


    public HomeScreen getHomeScreen (){
        return homeScreen == null ? homeScreen = new HomeScreen(driver) : homeScreen;
    }

    public ProductsScreen getProductScreen (){
        return productScreen == null ? productScreen = new ProductsScreen(driver) : productScreen;
    }
    public LoginScreen getLoginScreen (){
        return loginScreen == null ? loginScreen = new LoginScreen(driver) : loginScreen;
    }



}
