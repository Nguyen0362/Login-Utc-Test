package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Ranh giới Dữ liệu")
@DisplayName("TC16: Kiểm tra nhập toàn bộ các ký tự đặc biệt")
public class TC16_SpecialCharactersTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC16: Xử lý an toàn với chuỗi ký tự đặc biệt")
    public void testSpecialCharacters() {
        driver.findElement(By.name("username")).sendKeys("!@#$%^&*()_+~|}{[]:;?><,./-=");
        driver.findElement(By.name("userpwd")).sendKeys("!@#$%^&*()_+");
        driver.findElement(By.cssSelector("input.submit_login")).click();

        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống xử lý an toàn với các ký tự đặc biệt");
    }
}
