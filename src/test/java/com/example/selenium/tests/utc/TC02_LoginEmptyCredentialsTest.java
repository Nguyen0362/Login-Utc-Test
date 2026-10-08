package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TC02: Kiểm tra đăng nhập khi để trống thông tin")
public class TC02_LoginEmptyCredentialsTest extends BaseTest {

    private static final String LOGIN_URL = "https://vanphongdientu.utc.edu.vn/Login";

    @BeforeEach
    public void setupTest() {
        driver.get(LOGIN_URL);
    }

    @Test
    @DisplayName("TC02: Để trống Tên đăng nhập & Mật khẩu khi bấm Đăng nhập bằng Selenium")
    public void testLoginWithEmptyFields() {
        // Selenium: Tìm nút Đăng nhập và click
        WebElement btnSubmit = driver.findElement(By.cssSelector("input.submit_login"));
        btnSubmit.click();

        // Xác nhận người dùng vẫn ở lại trang Login, không được chuyển vào trong
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Người dùng phải vẫn ở trang Đăng nhập khi không nhập thông tin");
    }
}
