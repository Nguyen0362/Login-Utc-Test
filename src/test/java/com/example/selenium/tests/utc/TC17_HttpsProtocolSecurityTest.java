package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Bảo mật Giao thức")
@DisplayName("TC17: Xác minh kết nối sử dụng giao thức bảo mật HTTPS")
public class TC17_HttpsProtocolSecurityTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC17: Trang web chạy trên giao thức an toàn https://")
    public void testHttpsSecurity() {
        assertTrue(driver.getCurrentUrl().startsWith("https://"),
                "URL của trang đăng nhập phải bắt đầu bằng https:// để bảo vệ dữ liệu truyền tải");
    }
}
