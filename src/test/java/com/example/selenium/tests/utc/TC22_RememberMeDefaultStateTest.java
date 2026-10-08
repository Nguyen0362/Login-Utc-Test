package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Khả năng sử dụng (Usability Testing)")
@DisplayName("TC22: Kiểm tra trạng thái mặc định của checkbox 'Giữ tôi luôn đăng nhập'")
public class TC22_RememberMeDefaultStateTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC22: Checkbox mặc định không được chọn khi vào trang")
    public void testRememberMeDefaultState() {
        boolean isSelected = driver.findElement(By.id("persistent")).isSelected();
        assertFalse(isSelected, "Checkbox 'Giữ tôi luôn đăng nhập' mặc định không được chọn");
    }
}
