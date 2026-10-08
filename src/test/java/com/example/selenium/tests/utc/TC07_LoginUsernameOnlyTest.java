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
@DisplayName("TC07: Nhập Tên đăng nhập nhưng để trống Mật khẩu")
public class TC07_LoginUsernameOnlyTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC07: Không thể đăng nhập khi thiếu mật khẩu")
    public void testLoginWithUsernameOnly() {
        driver.findElement(By.name("username")).sendKeys("sinhvien_utc");
        driver.findElement(By.cssSelector("input.submit_login")).click();

        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống không được đăng nhập khi thiếu mật khẩu");
    }
}
