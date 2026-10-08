package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TC04: Kiểm tra tính năng Quên mật khẩu đăng nhập")
public class TC04_ForgotPasswordTest extends BaseTest {

    private static final String LOGIN_URL = "https://vanphongdientu.utc.edu.vn/Login";

    @BeforeEach
    public void setupTest() {
        driver.get(LOGIN_URL);
    }

    @Test
    @DisplayName("TC04: Kiểm tra link 'Bạn quên mật khẩu đăng nhập ?' và điều hướng tới /Login/GetPass bằng Selenium")
    public void testForgotPasswordLink() {
        // Selenium: Tìm link bằng XPath
        WebElement linkForgot = driver.findElement(By.xpath("//a[contains(@href, '/Login/GetPass')]"));

        String forgotUrl = linkForgot.getAttribute("href");
        assertNotNull(forgotUrl, "Đường dẫn quên mật khẩu không được rỗng");
        assertTrue(forgotUrl.contains("/Login/GetPass"), "Đường dẫn quên mật khẩu phải trỏ đến /Login/GetPass");

        // Selenium: Click chuyển hướng
        linkForgot.click();

        assertTrue(driver.getCurrentUrl().contains("GetPass"),
                "Sau khi click phải chuyển hướng tới trang Quên mật khẩu");
    }
}
