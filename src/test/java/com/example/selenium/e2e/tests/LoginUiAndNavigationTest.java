package com.example.selenium.e2e.tests;

import com.example.selenium.e2e.base.BaseTest;
import com.example.selenium.e2e.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Giao diện & Điều hướng (UI & Navigation Testing)")
@DisplayName("Kiểm thử Giao diện & Liên kết Hệ thống")
public class LoginUiAndNavigationTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setupPage() {
        loginPage = new LoginPage(driver);
        loginPage.open(baseUrl);
    }

    @Test
    @Story("Tiêu đề & Khung nhìn")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC14 - Kiểm tra tiêu đề trang (Page Title)")
    @Description("Tiêu đề trang phải hiển thị đúng chữ 'Đăng nhập'")
    public void testPageTitle() {
        assertEquals("Đăng nhập", loginPage.getTitle(), "Tiêu đề trang không chính xác");
    }

    @Test
    @Story("Trải nghiệm văn bản gợi ý")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC15 - Kiểm tra văn bản gợi ý (Placeholder) của Tên đăng nhập và Mật khẩu")
    @Description("Placeholder của username phải là 'Tên đăng nhập', mật khẩu là 'Mật khẩu'")
    public void testInputPlaceholders() {
        assertEquals("Tên đăng nhập", loginPage.getUsernamePlaceholder(),
                "Placeholder trường Tên đăng nhập không đúng");
        assertEquals("Mật khẩu", loginPage.getPasswordPlaceholder(),
                "Placeholder trường Mật khẩu không đúng");
    }

    @Test
    @Story("Hình ảnh & Khẩu hiệu thương hiệu")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC16 - Kiểm tra hiển thị hình ảnh banner và khẩu hiệu")
    @Description("Kiểm tra ảnh minh họa và câu slogan 'Làm việc mọi lúc mọi nơi'")
    public void testBannerAndSlogan() {
        assertTrue(loginPage.isBannerImageDisplayed(), "Hình ảnh banner bên trái phải hiển thị");
        assertTrue(loginPage.getBannerText().contains("Không chỉ là một giải pháp quản lý"),
                "Khẩu hiệu chính của banner không hiển thị");
        assertTrue(loginPage.getBannerSubtitleText().contains("Làm việc mọi lúc mọi nơi"),
                "Khẩu hiệu phụ của banner không hiển thị");
    }

    @Test
    @Story("Thông tin Bản quyền")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC17 - Kiểm tra thông tin bản quyền trường ở chân trang (Footer)")
    @Description("Chân trang phải chứa thông tin bản quyền ĐH Giao Thông Vận Tải")
    public void testCopyrightFooter() {
        assertTrue(loginPage.getCopyrightText().contains("Trường ĐH Giao Thông Vận Tải"),
                "Chân trang không có thông tin Trường ĐH Giao Thông Vận Tải");
    }

    @Test
    @Story("Chuyển hướng Quên mật khẩu")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC18 - Kiểm tra chuyển hướng liên kết 'Bạn quên mật khẩu đăng nhập ?'")
    @Description("Click liên kết phải chuyển hướng thành công đến trang /Login/GetPass")
    public void testForgotPasswordNavigation() {
        String href = loginPage.getForgotPasswordLinkHref();
        assertNotNull(href);
        assertTrue(href.contains("/Login/GetPass"));

        loginPage.clickForgotPassword();
        assertTrue(driver.getCurrentUrl().contains("GetPass"),
                "Không chuyển hướng được tới trang Quên mật khẩu");
    }

    @Test
    @Story("Liên kết hỗ trợ bên ngoài")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC19 - Kiểm tra liên kết Trung tâm trợ giúp và Ý kiến phản hồi")
    @Description("Kiểm tra đúng địa chỉ cổng hỗ trợ kỹ thuật và email phản hồi")
    public void testSupportAndFeedbackLinks() {
        String helpHref = loginPage.getHelpCenterHref();
        assertEquals("_blank", loginPage.getHelpCenterTarget(),
                "Trung tâm trợ giúp phải mở trong tab mới (target='_blank')");
        assertTrue(helpHref.contains("hotrokythuat.utc.edu.vn"),
                "Link trung tâm trợ giúp không chính xác");

        String feedbackHref = loginPage.getFeedbackHref();
        assertTrue(feedbackHref.contains("mailto:hotrokythuat@utc.edu.vn"),
                "Link phản hồi phải là mailto tới ban hỗ trợ kỹ thuật UTC");
    }
}
