package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TC01: Kiểm tra giao diện và các thành phần trang Đăng nhập UTC")
public class TC01_LoginPageElementsTest extends BaseTest {

    private static final String LOGIN_URL = "https://vanphongdientu.utc.edu.vn/Login";

    @BeforeEach
    public void setupTest() {
        // Selenium: Mở đường dẫn trang web
        driver.get(LOGIN_URL);
    }

    @Test
    @DisplayName("TC01: Kiểm tra tiêu đề, banner, các input và thông tin bản quyền bằng Selenium WebDriver")
    public void testLoginPageUIElements() {
        // 1. Selenium WebDriver: Lấy tiêu đề trang
        assertEquals("Đăng nhập", driver.getTitle(), "Tiêu đề trang phải là 'Đăng nhập'");

        // 2. Selenium WebDriver: Tìm các phần tử trên trang
        WebElement txtUsername = driver.findElement(By.name("username"));
        WebElement txtPassword = driver.findElement(By.name("userpwd"));
        WebElement btnSubmit = driver.findElement(By.cssSelector("input.submit_login"));
        WebElement bannerHeading = driver.findElement(By.cssSelector(".caption h1"));
        WebElement copyright = driver.findElement(By.cssSelector(".footer .left .a"));

        // 3. Khẳng định các phần tử hiển thị chính xác
        assertTrue(txtUsername.isDisplayed(), "Ô nhập 'Tên đăng nhập' phải hiển thị");
        assertTrue(txtPassword.isDisplayed(), "Ô nhập 'Mật khẩu' phải hiển thị");
        assertTrue(btnSubmit.isDisplayed(), "Nút 'Đăng nhập' phải hiển thị");
        assertTrue(bannerHeading.getText().contains("Không chỉ là một giải pháp quản lý"),
                "Banner phải chứa câu khẩu hiệu của hệ thống");
        assertTrue(copyright.getText().contains("Trường ĐH Giao Thông Vận Tải"),
                "Chân trang phải hiển thị bản quyền Trường ĐH Giao Thông Vận Tải");
    }
}
