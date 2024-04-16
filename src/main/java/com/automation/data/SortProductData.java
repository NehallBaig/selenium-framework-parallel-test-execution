package com.automation.data;

import org.testng.annotations.DataProvider;

public class SortProductData {

    @DataProvider(name = "sortingCriteria")
    public static Object[][] getSortingCriteria() {
        return new Object[][] {
                {"Price (low to high)"},
                {"Price (high to low)"},
                {"Name (A to Z)"},
                {"Name (Z to A)"}
        };
    }
}
