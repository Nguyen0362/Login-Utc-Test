package com.example.selenium.e2e.tests;

import com.example.selenium.e2e.base.BaseTest;
import com.example.selenium.e2e.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Bảo mật và Xác thực Dữ liệu (Security & Validation Testing)")
@DisplayName("Kiểm thử Bảo mật & Ranh giới Dữ liệu")
public class LoginSecurityAndValidationTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setupPage() {
        loginPage = new LoginPage(driver);
        loginPage.open(baseUrl);
    }

    @Test
    @Story("Bảo vệ Mật khẩu")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC08 - Kiểm tra trường Mật khẩu phải được mã hóa dạng password (Masked Input)")
    @Description("Thuộc tính type của trường mật khẩu phải là 'password' để tránh lộ thông tin")
    public void testPasswordMasking() {
        assertEquals("password", loginPage.getPasswordInputType(),
                "Trường mật khẩu bắt buộc phải có thuộc tính type='password'");
    }

    @Test
    @Story("Phòng chống SQL Injection")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("TC09 - Thử nghiệm đăng nhập với chuỗi tấn công SQL Injection")
    @Description("Hệ thống phải chống được các chuỗi SQL Injection cơ bản như ' OR '1'='1")
    public void testSqlInjectionAttackVector() {
        loginPage.login("' OR '1'='1' --", "' OR '1'='1'");
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống phải an toàn trước injection, không được phép lọt vào dashboard");
    }

    @Test
    @Story("Phòng chống XSS (Cross-Site Scripting)")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC10 - Thử nghiệm nhập chuỗi mã độc XSS Script")
    @Description("Hệ thống không được thực thi mã script chèn qua ô input")
    public void testXssAttackVector() {
        loginPage.login("<script>alert('XSS_TEST')</script>", "Password@123");
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống phải xử lý an toàn chuỗi XSS và vẫn hiển thị trang login");
    }

    @Test
    @Story("Kiểm thử Giá trị Biên (Boundary Testing)")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC11 - Kiểm thử độ dài chuỗi ký tự cực lớn (> 255 ký tự)")
    @Description("Hệ thống xử lý ổn định khi người dùng nhập chuỗi vượt độ dài thông thường")
    public void testExcessivelyLongInput() {
        String longText = "a".repeat(300);
        loginPage.login(longText, longText);
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống không bị sập (crash) khi nhận chuỗi độ dài lớn");
    }

    @Test
    @Story("Ký tự đặc biệt")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC12 - Kiểm tra nhập toàn bộ các ký tự đặc biệt")
    @Description("Kiểm tra hệ thống chấp nhận các ký tự đặc biệt mà không gây lỗi runtime")
    public void testSpecialCharactersInCredentials() {
        loginPage.login("!@#$%^&*()_+~|}{[]:;?><,./-=", "!@#$%^&*()_+");
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống xử lý an toàn với các ký tự đặc biệt");
    }

    @Test
    @Story("Bảo mật Giao thức Mạng")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC13 - Xác minh kết nối sử dụng giao thức bảo mật HTTPS")
    @Description("Trang web đăng nhập bắt buộc phải chạy qua giao thức HTTPS")
    public void testHttpsProtocolSecurity() {
        assertTrue(driver.getCurrentUrl().startsWith("https://"),
                "URL của trang đăng nhập phải bắt đầu bằng https:// để mã hóa dữ liệu truyền tải");
    }
}
