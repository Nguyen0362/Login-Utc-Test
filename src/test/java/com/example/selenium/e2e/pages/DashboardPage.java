package com.example.selenium.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * DashboardPage: Quản lý Header, Menu, thông tin user sau khi đăng nhập thành công
 */
public class DashboardPage extends BasePage {

    private final By userProfileMenu = By.cssSelector(".user-profile");
    private final By logoutButton = By.xpath("//a[contains(text(), 'Đăng xuất')]");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardLoaded() {
        return isDisplayed(userProfileMenu);
    }

    public void logout() {
        click(logoutButton);
    }
}
