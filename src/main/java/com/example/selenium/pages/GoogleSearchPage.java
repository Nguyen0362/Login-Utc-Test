package com.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage extends BasePage {

    // Locators
    private final By searchInput = By.name("q");

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoogleSearchPage open(String url) {
        driver.get(url);
        return this;
    }

    public GoogleResultPage searchFor(String query) {
        type(searchInput, query);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
        return new GoogleResultPage(driver);
    }
}
