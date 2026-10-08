package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Bảo mật")
@DisplayName("TC12: Kiểm tra trường Mật khẩu phải được che (Masked Input)")
public class TC12_PasswordMaskingTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC12: Trường mật khẩu phải có thuộc tính type='password'")
    public void testPasswordMasking() {
        String inputType = driver.findElement(By.name("userpwd")).getAttribute("type");
        assertEquals("password", inputType, "Trường mật khẩu bắt buộc phải có thuộc tính type='password'");
    }
}
