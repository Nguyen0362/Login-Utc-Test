package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Giao diện (UI Testing)")
@DisplayName("TC18: Kiểm tra văn bản gợi ý (Placeholder)")
public class TC18_InputPlaceholdersTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC18: Placeholder ô Tên đăng nhập và Mật khẩu")
    public void testPlaceholders() {
        String userPh = driver.findElement(By.name("username")).getAttribute("placeholder");
        String passPh = driver.findElement(By.name("userpwd")).getAttribute("placeholder");

        assertEquals("Tên đăng nhập", userPh, "Placeholder ô Tên đăng nhập không đúng");
        assertEquals("Mật khẩu", passPh, "Placeholder ô Mật khẩu không đúng");
    }
}
