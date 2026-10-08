package com.example.selenium.tests;

import com.example.selenium.pages.UtcLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bộ kiểm thử tự động trang Đăng nhập Văn phòng điện tử UTC")
public class UtcLoginTest extends BaseTest {

    private UtcLoginPage loginPage;

    @BeforeEach
    public void setupTest() {
        loginPage = new UtcLoginPage(driver);
        loginPage.open();
    }

    @Test
    @DisplayName("TC01: Kiểm tra giao diện và các thành phần chính trên trang Đăng nhập")
    public void testLoginPageUIElements() {
        // 1. Kiểm tra tiêu đề trang
        assertEquals("Đăng nhập", loginPage.getTitle(), "Tiêu đề trang phải là 'Đăng nhập'");

        // 2. Kiểm tra các ô nhập liệu và nút bấm
        assertTrue(loginPage.isUsernameFieldDisplayed(), "Ô nhập 'Tên đăng nhập' phải hiển thị");
        assertTrue(loginPage.isPasswordFieldDisplayed(), "Ô nhập 'Mật khẩu' phải hiển thị");
        assertTrue(loginPage.isSubmitButtonDisplayed(), "Nút 'Đăng nhập' phải hiển thị");

        // 3. Kiểm tra thông điệp trên banner
        assertTrue(loginPage.getBannerHeadingText().contains("Không chỉ là một giải pháp quản lý"),
                "Banner phải chứa câu khẩu hiệu của hệ thống");

        // 4. Kiểm tra thông tin bản quyền trường
        assertTrue(loginPage.getCopyrightText().contains("Trường ĐH Giao Thông Vận Tải"),
                "Chân trang phải hiển thị bản quyền Trường ĐH Giao Thông Vận Tải");
    }

    @Test
    @DisplayName("TC02: Đăng nhập để trống tài khoản và mật khẩu")
    public void testLoginWithEmptyFields() {
        loginPage.clickLogin();

        // Kiểm tra sau khi submit để trống, hệ thống không cho phép đăng nhập thành công và vẫn ở lại trang Login
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Người dùng phải vẫn ở trang Đăng nhập khi không nhập thông tin");
    }

    @Test
    @DisplayName("TC03: Đăng nhập với tài khoản và mật khẩu không hợp lệ")
    public void testLoginWithInvalidCredentials() {
        loginPage.enterUsername("sinhvien_test_invalid")
                 .enterPassword("MatKhauSai@123");
        loginPage.clickLogin();

        // Kiểm tra hệ thống từ chối đăng nhập (vẫn ở trang /Login)
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống phải từ chối truy cập và giữ ở trang đăng nhập");
    }

    @Test
    @DisplayName("TC04: Kiểm tra liên kết 'Bạn quên mật khẩu đăng nhập ?'")
    public void testForgotPasswordLink() {
        String forgotUrl = loginPage.getForgotPasswordUrl();
        assertNotNull(forgotUrl, "Đường dẫn quên mật khẩu không được rỗng");
        assertTrue(forgotUrl.contains("/Login/GetPass"), "Đường dẫn quên mật khẩu phải trỏ đến /Login/GetPass");

        loginPage.clickForgotPassword();
        assertTrue(driver.getCurrentUrl().contains("/Login/GetPass") || driver.getCurrentUrl().contains("GetPass"),
                "Sau khi click phải chuyển hướng tới trang Quên mật khẩu");
    }

    @Test
    @DisplayName("TC05: Kiểm tra nút 'Đăng nhập bằng e-mail UTC'")
    public void testUtcEmailSsoLink() {
        String googleOAuthUrl = loginPage.getEmailUtcLoginUrl();
        assertNotNull(googleOAuthUrl, "Đường dẫn đăng nhập qua email UTC không được rỗng");
        assertTrue(googleOAuthUrl.contains("accounts.google.com/o/oauth2"),
                "Đường dẫn đăng nhập phải là cổng xác thực Google OAuth 2.0");
    }

    @Test
    @DisplayName("TC06: Kiểm tra tính năng bật/tắt checkbox 'Giữ tôi luôn đăng nhập'")
    public void testRememberMeToggle() {
        boolean initialState = loginPage.isRememberMeChecked();
        
        // Click để thay đổi trạng thái
        loginPage.toggleRememberMe();
        boolean toggledState = loginPage.isRememberMeChecked();
        assertNotEquals(initialState, toggledState, "Trạng thái checkbox phải thay đổi sau khi click");

        // Click lần nữa để hoàn nguyên
        loginPage.toggleRememberMe();
        assertEquals(initialState, loginPage.isRememberMeChecked(), "Trạng thái checkbox phải quay về ban đầu");
    }
}
