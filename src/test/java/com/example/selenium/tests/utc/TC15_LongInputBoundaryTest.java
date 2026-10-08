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
@DisplayName("TC15: Kiểm thử độ dài chuỗi ký tự cực lớn (> 255 ký tự)")
public class TC15_LongInputBoundaryTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC15: Hệ thống không bị crash khi nhận chuỗi độ dài 300 ký tự")
    public void testLongInput() {
        String longText = "a".repeat(300);
        driver.findElement(By.name("username")).sendKeys(longText);
        driver.findElement(By.name("userpwd")).sendKeys(longText);
        driver.findElement(By.cssSelector("input.submit_login")).click();

        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Hệ thống không bị sập khi nhận chuỗi độ dài lớn");
    }
}
