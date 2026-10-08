package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TC03: Kiểm tra đăng nhập với thông tin không hợp lệ")
public class TC03_LoginInvalidCredentialsTest extends BaseTest {

    private static final String LOGIN_URL = "https://vanphongdientu.utc.edu.vn/Login";

    @BeforeEach
    public void setupTest() {
        driver.get(LOGIN_URL);
    }

    @Test
    @DisplayName("TC03: Nhập tài khoản và mật khẩu sai bằng Selenium sendKeys()")
    public void testLoginWithInvalidCredentials() {
        // Selenium WebDriver: Tìm các trường nhập liệu
        WebElement txtUsername = driver.findElement(By.name("username"));
        WebElement txtPassword = driver.findElement(By.name("userpwd"));
        WebElement btnSubmit = driver.findElement(By.cssSelector("input.submit_login"));

        // Selenium: Thao tác xóa và nhập dữ liệu giả lập
        txtUsername.clear();
        txtUsername.sendKeys("sinhvien_test_invalid");

        txtPassword.clear();
        txtPassword.sendKeys("MatKhauSai@123");

        // Selenium: Click submit
        btnSubmit.click();

        // Xác nhận hệ thống từ chối xác thực và vẫn giữ ở trang đăng nhập
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống phải từ chối truy cập và giữ ở trang đăng nhập");
    }
}
