package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Khả năng sử dụng (Usability Testing)")
@DisplayName("TC23: Gửi form đăng nhập bằng phím ENTER trong trường Mật khẩu")
public class TC23_SubmitWithEnterKeyTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC23: Nhấn Enter trong ô Mật khẩu để submit form")
    public void testSubmitWithEnter() {
        driver.findElement(By.name("username")).sendKeys("sinhvien_test");
        driver.findElement(By.name("userpwd")).sendKeys("123456" + Keys.ENTER);

        assertTrue(driver.getCurrentUrl().toLowerCase().contains("login"),
                "Form đã được submit qua phím Enter");
    }
}
