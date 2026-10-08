package com.example.selenium.standalone;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * File kiểm thử thuần Selenium WebDriver trực tiếp trong 1 file (không qua lớp trung gian)
 * Rất trực quan để nộp bài hoặc báo cáo đồ án Kiểm thử phần mềm.
 */
@DisplayName("Kiểm thử Selenium WebDriver thuần trực tiếp")
public class UtcLoginDirectSeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // 1. Tích hợp ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // 2. Tích hợp Selenium ChromeDriver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 3. Mở URL trang web bằng Selenium
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @DisplayName("Kiểm thử tương tác trực tiếp bằng Selenium: Đăng nhập với tài khoản sai")
    public void testDirectSeleniumLogin() {
        // Kiểm tra tiêu đề trang
        assertEquals("Đăng nhập", driver.getTitle());

        // Định vị các WebElement bằng By.name và By.cssSelector
        WebElement txtUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement txtPassword = driver.findElement(By.name("userpwd"));
        WebElement btnSubmit = driver.findElement(By.cssSelector("input.submit_login"));

        // Tương tác Selenium: sendKeys và click
        txtUsername.clear();
        txtUsername.sendKeys("sinhvien_utc_test");

        txtPassword.clear();
        txtPassword.sendKeys("MatKhauSai@2026");

        btnSubmit.click();

        // Kiểm tra sau khi submit vẫn ở trang đăng nhập
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"));
    }

    @AfterEach
    public void tearDown() {
        // Đóng trình duyệt sau khi test xong
        if (driver != null) {
            driver.quit();
        }
    }
}
