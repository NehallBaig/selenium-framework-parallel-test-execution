package com.automation.pages;

import com.automation.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsScreen extends AbstractScreen{

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrice;

    @FindBy(xpath = "//*[text()='Products']")
    private WebElement productTitleLabel;

    public ProductsScreen(WebDriver driver){
        super(driver);
    }

    public boolean productLabelIsDisplayed() {
        return Utility.waitForWebElement(driver, productTitleLabel, 5);
    }

    public boolean validateMaxProductPrice(double price){
        List<Double> priceList = productPrice.stream()
                .map(this::convertCurrency).sorted().toList();

        double maxPrice = priceList.get(priceList.size()-1);
        System.out.println("Product list max price "+maxPrice);
        return maxPrice == price;
    }

    private double convertCurrency(WebElement element){
        String priceText = element.getText();
        return Double.parseDouble(priceText.replaceAll("\\$","").replaceAll(",",""));
    }

}
