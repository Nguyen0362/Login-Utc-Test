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
@DisplayName("TC09: Đăng nhập với tài khoản đúng định dạng nhưng sai mật khẩu")
public class TC09_LoginWrongPasswordTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC09: Hệ thống từ chối khi mật khẩu không đúng")
    public void testLoginWithWrongPassword() {
        driver.findElement(By.name("username")).sendKeys("admin@utc.edu.vn");
        driver.findElement(By.name("userpwd")).sendKeys("SaiPasscode123!");
        driver.findElement(By.cssSelector("input.submit_login")).click();

        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống phải từ chối khi mật khẩu không trùng khớp");
    }
}
