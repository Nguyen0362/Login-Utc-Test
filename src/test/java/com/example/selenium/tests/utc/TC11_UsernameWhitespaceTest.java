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
@DisplayName("TC11: Nhập Tên đăng nhập có khoảng trắng ở đầu và cuối")
public class TC11_UsernameWhitespaceTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC11: Hệ thống xử lý an toàn với khoảng trắng thừa")
    public void testUsernameWithWhitespace() {
        driver.findElement(By.name("username")).sendKeys("  sinhvien_utc  ");
        driver.findElement(By.name("userpwd")).sendKeys("MatKhau@123");
        driver.findElement(By.cssSelector("input.submit_login")).click();

        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống không bị sập và giữ an toàn trên trang đăng nhập");
    }
}
