package com.example.selenium.e2e.tests;

import com.example.selenium.e2e.base.BaseTest;
import com.example.selenium.e2e.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Kiểm thử E2E: Form Đăng nhập (LoginE2ETest)")
public class LoginE2ETest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setupPage() {
        loginPage = new LoginPage(driver);
        loginPage.open(baseUrl);
    }

    @Test
    @DisplayName("TC01 - Kiểm tra giao diện và các phần tử cơ bản")
    public void testLoginPageUIElements() {
        assertEquals("Đăng nhập", loginPage.getTitle());
        assertTrue(loginPage.isUsernameInputDisplayed(), "Trường Tên đăng nhập phải hiển thị");
        assertTrue(loginPage.isPasswordInputDisplayed(), "Trường Mật khẩu phải hiển thị");
        assertTrue(loginPage.isLoginButtonDisplayed(), "Nút Đăng nhập phải hiển thị");
        assertTrue(loginPage.getBannerText().contains("Không chỉ là một giải pháp quản lý"));
        assertTrue(loginPage.getCopyrightText().contains("Trường ĐH Giao Thông Vận Tải"));
    }

    @Test
    @DisplayName("TC02 - Đăng nhập khi để trống tài khoản và mật khẩu")
    public void testLoginWithEmptyCredentials() {
        loginPage.clickLogin();

        // Không được chuyển hướng vào trong, vẫn giữ ở trang Login
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Người dùng phải vẫn ở trang Đăng nhập");
    }

    @Test
    @DisplayName("TC03 - Đăng nhập với tài khoản không hợp lệ")
    public void testLoginWithInvalidCredentials() {
        loginPage.login("sinhvien_sai@utc.edu.vn", "SaiMatKhau123");

        // Hệ thống từ chối xác thực, vẫn ở trang đăng nhập
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống phải từ chối truy cập và giữ ở trang đăng nhập");
    }

    @Test
    @DisplayName("TC04 - Kiểm tra tính năng Quên mật khẩu")
    public void testForgotPasswordNavigation() {
        String href = loginPage.getForgotPasswordLinkHref();
        assertNotNull(href);
        assertTrue(href.contains("/Login/GetPass"));

        loginPage.clickForgotPassword();
        assertTrue(driver.getCurrentUrl().contains("GetPass"),
                "Chuyển hướng tới trang Quên mật khẩu thành công");
    }

    @Test
    @DisplayName("TC05 - Kiểm tra liên kết đăng nhập bằng Google OAuth UTC")
    public void testUtcEmailSsoLink() {
        String ssoUrl = loginPage.getUtcEmailLoginHref();
        assertNotNull(ssoUrl);
        assertTrue(ssoUrl.contains("accounts.google.com/o/oauth2"),
                "Liên kết SSO phải dẫn tới Google OAuth 2.0");
    }

    @Test
    @DisplayName("TC06 - Kiểm tra tính năng bật/tắt checkbox Ghi nhớ đăng nhập")
    public void testRememberMeToggle() {
        boolean initial = loginPage.isRememberMeSelected();

        loginPage.toggleRememberMe();
        assertNotEquals(initial, loginPage.isRememberMeSelected());

        loginPage.toggleRememberMe();
        assertEquals(initial, loginPage.isRememberMeSelected());
    }
}
