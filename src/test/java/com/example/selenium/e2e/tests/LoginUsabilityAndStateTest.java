package com.example.selenium.e2e.tests;

import com.example.selenium.e2e.base.BaseTest;
import com.example.selenium.e2e.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Trạng thái & Khả năng Sử dụng (Usability & State Testing)")
@DisplayName("Kiểm thử Trạng thái Checkbox & Phím Enter")
public class LoginUsabilityAndStateTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setupPage() {
        loginPage = new LoginPage(driver);
        loginPage.open(baseUrl);
    }

    @Test
    @Story("Trạng thái mặc định")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC20 - Kiểm tra trạng thái mặc định của checkbox 'Giữ tôi luôn đăng nhập'")
    @Description("Mặc định khi vào trang, checkbox không được tích chọn để đảm bảo an toàn")
    public void testRememberMeDefaultState() {
        assertFalse(loginPage.isRememberMeSelected(),
                "Checkbox 'Giữ tôi luôn đăng nhập' mặc định không được chọn");
    }

    @Test
    @Story("Tương tác người dùng")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC21 - Kiểm tra chuyển đổi trạng thái (Toggle) checkbox 'Giữ tôi luôn đăng nhập'")
    @Description("Người dùng click để chọn và click lần nữa để hủy chọn")
    public void testRememberMeToggleState() {
        loginPage.toggleRememberMe();
        assertTrue(loginPage.isRememberMeSelected(), "Sau lần click đầu tiên, checkbox phải được chọn");

        loginPage.toggleRememberMe();
        assertFalse(loginPage.isRememberMeSelected(), "Sau lần click thứ hai, checkbox phải trở về trạng thái bỏ chọn");
    }

    @Test
    @Story("Khả năng sử dụng bàn phím")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC22 - Gửi form đăng nhập bằng phím ENTER trong trường Mật khẩu")
    @Description("Người dùng có thể nhấn phím ENTER để submit mà không cần bấm chuột vào nút Đăng nhập")
    public void testSubmitUsingEnterInPasswordField() {
        loginPage.submitWithEnterInPassword("sinhvien_test", "123456");
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Form đã được submit thành công qua phím Enter");
    }

    @Test
    @Story("Khả năng sử dụng bàn phím")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC23 - Gửi form đăng nhập bằng phím ENTER trong trường Tên đăng nhập")
    @Description("Người dùng có thể nhấn ENTER ngay từ trường Tên đăng nhập")
    public void testSubmitUsingEnterInUsernameField() {
        loginPage.submitWithEnterInUsername("sinhvien_test");
        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Form được submit bằng phím Enter trong ô Tên đăng nhập");
    }

    @Test
    @Story("Dọn dẹp form")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC24 - Thao tác xóa trắng dữ liệu (Clear fields)")
    @Description("Kiểm tra khả năng xóa dữ liệu cũ đã nhập trong các ô")
    public void testClearFieldsFunctionality() {
        loginPage.enterUsername("tai_khoan_cu")
                 .enterPassword("mat_khau_cu");

        loginPage.clearFields();

        assertEquals("", loginPage.getUsernameValue(), "Ô tên đăng nhập phải trống sau khi clear");
        assertEquals("", loginPage.getPasswordValue(), "Ô mật khẩu phải trống sau khi clear");
    }
}
