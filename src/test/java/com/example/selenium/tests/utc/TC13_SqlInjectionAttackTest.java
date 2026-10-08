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
@DisplayName("TC13: Thử nghiệm chuỗi tấn công SQL Injection")
public class TC13_SqlInjectionAttackTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("TC13: Hệ thống chặn tấn công SQL Injection (' OR '1'='1)")
    public void testSqlInjectionAttack() {
        driver.findElement(By.name("username")).sendKeys("' OR '1'='1' --");
        driver.findElement(By.name("userpwd")).sendKeys("' OR '1'='1'");
        driver.findElement(By.cssSelector("input.submit_login")).click();

        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống phải an toàn trước injection, không được phép lọt vào trong");
    }
}
