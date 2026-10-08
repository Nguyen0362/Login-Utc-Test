package com.example.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumBasicTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Chạy headless khi test tự động để nhanh và ổn định:
        options.addArguments("--headless=new");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    @DisplayName("Kiểm tra mở Google và tìm kiếm thành công")
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        assertTrue(title.contains("Google"), "Tiêu đề trang phải chứa chữ 'Google'");

        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        assertNotNull(searchBox, "Không tìm thấy ô tìm kiếm Google");

        searchBox.sendKeys("Selenium 4");
        searchBox.submit();

        wait.until(ExpectedConditions.titleContains("Selenium"));
        assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
