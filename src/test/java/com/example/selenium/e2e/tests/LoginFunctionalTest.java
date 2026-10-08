package com.example.selenium.e2e.tests;

import com.example.selenium.e2e.base.BaseTest;
import com.example.selenium.e2e.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Chức năng Đăng nhập (Functional Testing)")
@DisplayName("Kiểm thử Chức năng Form Đăng nhập UTC")
public class LoginFunctionalTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setupPage() {
        loginPage = new LoginPage(driver);
        loginPage.open(baseUrl);
    }

    @Test
    @Story("Xác thực đầu vào")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("TC01 - Đăng nhập khi để trống cả Tên đăng nhập và Mật khẩu")
    @Description("Hệ thống phải chặn đăng nhập và giữ người dùng ở lại trang Login")
    public void testLoginWithEmptyCredentials() {
        loginPage.clickLogin();
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Người dùng phải vẫn ở trang Đăng nhập");
    }

    @Test
    @Story("Xác thực đầu vào")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC02 - Nhập Tên đăng nhập nhưng để trống Mật khẩu")
    public void testLoginWithUsernameOnly() {
        loginPage.enterUsername("sinhvien_utc")
                 .clickLogin();
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống không được đăng nhập khi thiếu mật khẩu");
    }

    @Test
    @Story("Xác thực đầu vào")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC03 - Để trống Tên đăng nhập nhưng nhập Mật khẩu")
    public void testLoginWithPasswordOnly() {
        loginPage.enterPassword("MatKhau123456")
                 .clickLogin();
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống không được đăng nhập khi thiếu tên đăng nhập");
    }

    @Test
    @Story("Xác thực tài khoản")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC04 - Đăng nhập với tài khoản và mật khẩu không tồn tại")
    public void testLoginWithInvalidCredentials() {
        loginPage.login("taikhoan_khongtontai_9999", "MatKhauSai@123");
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống phải từ chối xác thực tài khoản không tồn tại");
    }

    @Test
    @Story("Xác thực tài khoản")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC05 - Đăng nhập với tài khoản đúng định dạng nhưng sai mật khẩu")
    public void testLoginWithWrongPassword() {
        loginPage.login("admin@utc.edu.vn", "SaiPasscode123!");
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống phải từ chối khi mật khẩu không trùng khớp");
    }

    @Test
    @Story("Quy chuẩn tài khoản")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC06 - Kiểm tra phân biệt chữ hoa/thường trong tên đăng nhập")
    public void testUsernameCaseSensitivity() {
        loginPage.login("SINHVIEN_UTC", "MatKhau@123");
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống xử lý an toàn không gặp lỗi runtime");
    }

    @Test
    @Story("Xử lý khoảng trắng")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC07 - Nhập Tên đăng nhập có khoảng trắng ở đầu và cuối")
    public void testUsernameWithWhitespace() {
        loginPage.login("  sinhvien_utc  ", "MatKhau@123");
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống không bị sập và giữ an toàn trên trang đăng nhập");
    }
}
