package com.example.selenium.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * LoginPage: Đại diện cho Form đăng nhập (Văn phòng điện tử UTC)
 * Bổ sung đầy đủ các bộ chọn phục vụ cho 24 kịch bản kiểm thử toàn diện
 */
public class LoginPage extends BasePage {

    // Locators
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("userpwd");
    private final By loginButton = By.cssSelector("input.submit_login");
    private final By rememberMeLabel = By.cssSelector("label[for='persistent']");
    private final By rememberMeCheckbox = By.id("persistent");
    private final By forgotPasswordLink = By.xpath("//a[contains(@href, '/Login/GetPass')]");
    private final By utcEmailLoginLink = By.xpath("//a[contains(text(), 'Đăng nhập bằng e-mail UTC')]");
    private final By bannerHeading = By.cssSelector(".caption h1");
    private final By bannerSubtitle = By.cssSelector(".caption span");
    private final By bannerImage = By.cssSelector(".left img");
    private final By copyrightFooter = By.cssSelector(".footer .left .a");
    private final By helpCenterLink = By.linkText("Trung tâm trợ giúp");
    private final By feedbackLink = By.linkText("Ý kiến phản hồi");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void submitWithEnterInPassword(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        driver.findElement(passwordInput).sendKeys(Keys.ENTER);
    }

    public void submitWithEnterInUsername(String username) {
        enterUsername(username);
        driver.findElement(usernameInput).sendKeys(Keys.ENTER);
    }

    public void toggleRememberMe() {
        click(rememberMeLabel);
    }

    public boolean isRememberMeSelected() {
        return driver.findElement(rememberMeCheckbox).isSelected();
    }

    public void clickForgotPassword() {
        click(forgotPasswordLink);
    }

    public String getForgotPasswordLinkHref() {
        return driver.findElement(forgotPasswordLink).getAttribute("href");
    }

    public String getUtcEmailLoginHref() {
        return driver.findElement(utcEmailLoginLink).getAttribute("href");
    }

    public String getHelpCenterHref() {
        return driver.findElement(helpCenterLink).getAttribute("href");
    }

    public String getHelpCenterTarget() {
        return driver.findElement(helpCenterLink).getAttribute("target");
    }

    public String getFeedbackHref() {
        return driver.findElement(feedbackLink).getAttribute("href");
    }

    public boolean isUsernameInputDisplayed() {
        return isDisplayed(usernameInput);
    }

    public boolean isPasswordInputDisplayed() {
        return isDisplayed(passwordInput);
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(loginButton);
    }

    public boolean isBannerImageDisplayed() {
        return isDisplayed(bannerImage);
    }

    public String getUsernamePlaceholder() {
        return driver.findElement(usernameInput).getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return driver.findElement(passwordInput).getAttribute("placeholder");
    }

    public String getPasswordInputType() {
        return driver.findElement(passwordInput).getAttribute("type");
    }

    public String getUsernameValue() {
        return driver.findElement(usernameInput).getAttribute("value");
    }

    public String getPasswordValue() {
        return driver.findElement(passwordInput).getAttribute("value");
    }

    public void clearFields() {
        driver.findElement(usernameInput).clear();
        driver.findElement(passwordInput).clear();
    }

    public String getBannerText() {
        return getText(bannerHeading);
    }

    public String getBannerSubtitleText() {
        return getText(bannerSubtitle);
    }

    public String getCopyrightText() {
        return getText(copyrightFooter);
    }
}
