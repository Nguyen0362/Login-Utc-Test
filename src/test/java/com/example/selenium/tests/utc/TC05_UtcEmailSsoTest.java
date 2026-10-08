package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TC05: Kiểm tra nút 'Đăng nhập bằng e-mail UTC'")
public class TC05_UtcEmailSsoTest extends BaseTest {

    private static final String LOGIN_URL = "https://vanphongdientu.utc.edu.vn/Login";

    @BeforeEach
    public void setupTest() {
        driver.get(LOGIN_URL);
    }

    @Test
    @DisplayName("TC05: Kiểm tra cổng đăng nhập liên kết với Google OAuth 2.0 bằng Selenium")
    public void testUtcEmailSsoLink() {
        // Selenium: Tìm thẻ <a> đăng nhập Google SSO
        WebElement linkGoogleSso = driver.findElement(By.xpath("//a[contains(text(), 'Đăng nhập bằng e-mail UTC')]"));

        String googleOAuthUrl = linkGoogleSso.getAttribute("href");
        assertNotNull(googleOAuthUrl, "Đường dẫn đăng nhập qua email UTC không được rỗng");
        assertTrue(googleOAuthUrl.contains("accounts.google.com/o/oauth2"),
                "Đường dẫn đăng nhập phải là cổng xác thực Google OAuth 2.0");
    }
}
