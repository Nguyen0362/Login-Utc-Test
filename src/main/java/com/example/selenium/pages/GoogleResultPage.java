package com.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleResultPage extends BasePage {

    private final By resultStats = By.id("result-stats");
    private final By searchResultsContainer = By.id("search");

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isResultPageDisplayed() {
        return driver.getTitle().toLowerCase().contains("selenium") 
                || isDisplayed(searchResultsContainer) 
                || isDisplayed(resultStats);
    }
}
