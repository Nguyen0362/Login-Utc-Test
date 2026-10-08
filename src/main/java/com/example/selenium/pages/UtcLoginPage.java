package com.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtcLoginPage extends BasePage {

    public static final String LOGIN_URL = "https://vanphongdientu.utc.edu.vn/Login";

    // Locators
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("userpwd");
    private final By submitButton = By.cssSelector("input.submit_login");
    private final By persistentLabel = By.cssSelector("label[for='persistent']");
    private final By persistentCheckbox = By.id("persistent");
    private final By forgotPasswordLink = By.xpath("//a[contains(@href, '/Login/GetPass')]");
    private final By emailUtcLoginLink = By.xpath("//a[contains(text(), 'Đăng nhập bằng e-mail UTC')]");
    private final By bannerHeading = By.cssSelector(".caption h1");
    private final By bannerSubtitle = By.cssSelector(".caption span");
    private final By copyrightText = By.cssSelector(".footer .left .a");

    public UtcLoginPage(WebDriver driver) {
        super(driver);
    }

    public UtcLoginPage open() {
        driver.get(LOGIN_URL);
        return this;
    }

    public UtcLoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public UtcLoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public void clickLogin() {
        click(submitButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void toggleRememberMe() {
        click(persistentLabel);
    }

    public boolean isRememberMeChecked() {
        return driver.findElement(persistentCheckbox).isSelected();
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

    public void clickEmailUtcLogin() {
        click(emailUtcLoginLink);
    }

    public String getForgotPasswordUrl() {
        return driver.findElement(forgotPasswordLink).getAttribute("href");
    }

    public String getEmailUtcLoginUrl() {
        return driver.findElement(emailUtcLoginLink).getAttribute("href");
    }

    public boolean isUsernameFieldDisplayed() {
        return isDisplayed(usernameInput);
    }

    public boolean isPasswordFieldDisplayed() {
        return isDisplayed(passwordInput);
    }

    public boolean isSubmitButtonDisplayed() {
        return isDisplayed(submitButton);
    }

    public String getBannerHeadingText() {
        return getText(bannerHeading);
    }

    public String getCopyrightText() {
        return getText(copyrightText);
    }
}
