package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Giao diện (UI Testing)")
@DisplayName("TC20: Kiểm tra thông tin bản quyền trường ở chân trang (Footer)")
public class TC20_CopyrightFooterTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC20: Hiển thị bản quyền Trường ĐH Giao Thông Vận Tải")
    public void testCopyright() {
        String footerText = driver.findElement(By.cssSelector(".footer .left .a")).getText();
        assertTrue(footerText.contains("Trường ĐH Giao Thông Vận Tải"),
                "Chân trang không có thông tin Trường ĐH Giao Thông Vận Tải");
    }
}
