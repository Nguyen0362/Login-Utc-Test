package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("TC06: Kiểm tra tính năng bật/tắt checkbox 'Giữ tôi luôn đăng nhập'")
public class TC06_RememberMeToggleTest extends BaseTest {

    private static final String LOGIN_URL = "https://vanphongdientu.utc.edu.vn/Login";

    @BeforeEach
    public void setupTest() {
        driver.get(LOGIN_URL);
    }

    @Test
    @DisplayName("TC06: Bật và tắt trạng thái của checkbox 'Giữ tôi luôn đăng nhập' bằng Selenium")
    public void testRememberMeToggle() {
        // Selenium: Tìm checkbox và nhãn bọc
        WebElement chkInput = driver.findElement(By.id("persistent"));
        WebElement chkLabel = driver.findElement(By.cssSelector("label[for='persistent']"));

        boolean initialState = chkInput.isSelected();

        // 1. Selenium click để thay đổi trạng thái
        chkLabel.click();
        boolean toggledState = chkInput.isSelected();
        assertNotEquals(initialState, toggledState, "Trạng thái checkbox phải thay đổi sau khi click");

        // 2. Selenium click lần nữa để hoàn nguyên về ban đầu
        chkLabel.click();
        assertEquals(initialState, chkInput.isSelected(), "Trạng thái checkbox phải quay về ban đầu");
    }
}
