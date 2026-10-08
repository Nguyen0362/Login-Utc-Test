package com.example.selenium.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * WatchlistPage: Quản lý danh sách tài khoản nghi vấn (theo slide Buổi 8)
 */
public class WatchlistPage extends BasePage {

    private final By watchlistTable = By.id("watchlist-table");
    private final By addAccountButton = By.id("btn-add-account");

    public WatchlistPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWatchlistDisplayed() {
        return isDisplayed(watchlistTable);
    }

    public void clickAddAccount() {
        click(addAccountButton);
    }
}
