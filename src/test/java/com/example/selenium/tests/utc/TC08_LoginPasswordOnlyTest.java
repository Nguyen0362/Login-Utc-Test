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
@DisplayName("TC08: Để trống Tên đăng nhập nhưng nhập Mật khẩu")
public class TC08_LoginPasswordOnlyTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC08: Không thể đăng nhập khi thiếu tên đăng nhập")
    public void testLoginWithPasswordOnly() {
        driver.findElement(By.name("userpwd")).sendKeys("MatKhau123456");
        driver.findElement(By.cssSelector("input.submit_login")).click();

        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống không được đăng nhập khi thiếu tên đăng nhập");
    }
}
