package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Bảo mật")
@DisplayName("TC14: Thử nghiệm nhập chuỗi mã độc XSS Script")
public class TC14_XssScriptAttackTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC14: Hệ thống không thực thi mã script chèn qua ô input")
    public void testXssAttack() {
        driver.findElement(By.name("username")).sendKeys("<script>alert('XSS_TEST')</script>");
        driver.findElement(By.name("userpwd")).sendKeys("Password@123");
        driver.findElement(By.cssSelector("input.submit_login")).click();

        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống phải xử lý an toàn chuỗi XSS và vẫn hiển thị trang login");
    }
}
