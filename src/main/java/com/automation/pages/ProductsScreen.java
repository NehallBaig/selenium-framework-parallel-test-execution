package com.automation.pages;

import com.automation.utils.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsScreen extends AbstractScreen {

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrice;

    @FindBy(xpath = "//*[text()='Products']")
    WebElement productTitleLabel;

    @FindBy(className = "product_sort_container")
    WebElement productFilterDropDown;

    @FindBy(className = "inventory_item_price")
    List<WebElement> productPriceList;


    public ProductsScreen(WebDriver driver) {
        super(driver);
    }

    public boolean productLabelIsDisplayed() {
        return Utility.waitForWebElement(driver, productTitleLabel, 5);
    }

    public boolean selectSortingFilter(String text) {
        if (Utility.waitForWebElement(driver, productFilterDropDown, 5)) {
            Utility.selectDropDownByVisibleText(productFilterDropDown, text);
            Utility.waitForSomeTime(5);
            return true;
        }
        return false;
    }

    public boolean validateSortingProduct(String sortingCriteria) {
        List<Double> prices = getProductPrices();

        // Verify that the products are sorted correctly
        return switch (sortingCriteria) {
            case "Price (low to high)" -> isSortedAscending(prices);
            case "Price (high to low)" -> isSortedDescending(prices);
            default -> {
                System.out.println("Unsupported sorting criteria: " + sortingCriteria);
                yield false;
            }
        };
    }

    // Need to refactor
    private boolean isSortedAscending(List<Double> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // Need to refactor
    private boolean isSortedDescending(List<Double> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) < values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement element : productPrice) {
            prices.add(convertCurrency(element));
        }
        return prices;
    }

    public boolean validateMaxProductPrice(double price) {
        List<Double> priceList = getProductPrices();
        double maxPrice = priceList.stream().max(Double::compare).orElse(0.0);
        System.out.println("Product list max price " + maxPrice);
        return maxPrice == price;
    }

    private double convertCurrency(WebElement element) {
        String priceText = element.getText();
        return Double.parseDouble(priceText.replaceAll("\\$", "").replaceAll(",", ""));
    }

}
