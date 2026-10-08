package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Khả năng sử dụng (Usability Testing)")
@DisplayName("TC24: Thao tác xóa trắng dữ liệu (Clear fields)")
public class TC24_ClearFieldsTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC24: Ô nhập liệu trống sau khi gọi hàm clear()")
    public void testClearFields() {
        WebElement txtUser = driver.findElement(By.name("username"));
        WebElement txtPass = driver.findElement(By.name("userpwd"));

        txtUser.sendKeys("tai_khoan_cu");
        txtPass.sendKeys("mat_khau_cu");

        txtUser.clear();
        txtPass.clear();

        assertEquals("", txtUser.getAttribute("value"), "Ô tên đăng nhập phải trống sau khi clear");
        assertEquals("", txtPass.getAttribute("value"), "Ô mật khẩu phải trống sau khi clear");
    }
}
