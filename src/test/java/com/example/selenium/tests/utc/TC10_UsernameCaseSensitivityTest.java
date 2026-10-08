package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Chức năng Đăng nhập")
@DisplayName("TC10: Kiểm tra phân biệt chữ hoa/thường trong tên đăng nhập")
public class TC10_UsernameCaseSensitivityTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC10: Đăng nhập với chữ hoa trong tên đăng nhập")
    public void testUsernameCaseSensitivity() {
        driver.findElement(By.name("username")).sendKeys("SINHVIEN_UTC");
        driver.findElement(By.name("userpwd")).sendKeys("MatKhau@123");
        driver.findElement(By.cssSelector("input.submit_login")).click();

        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống xử lý an toàn không gặp lỗi runtime");
    }
}
