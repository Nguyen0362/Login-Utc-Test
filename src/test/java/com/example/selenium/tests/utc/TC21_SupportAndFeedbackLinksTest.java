package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Điều hướng")
@DisplayName("TC21: Kiểm tra liên kết Trung tâm trợ giúp và Ý kiến phản hồi")
public class TC21_SupportAndFeedbackLinksTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC21: Link trợ giúp mở tab mới và link phản hồi là mailto")
    public void testSupportLinks() {
        WebElement helpLink = driver.findElement(By.linkText("Trung tâm trợ giúp"));
        assertEquals("_blank", helpLink.getAttribute("target"), "Trợ giúp phải mở trong tab mới");
        assertTrue(helpLink.getAttribute("href").contains("hotrokythuat.utc.edu.vn"));

        WebElement feedbackLink = driver.findElement(By.linkText("Ý kiến phản hồi"));
        assertTrue(feedbackLink.getAttribute("href").contains("mailto:hotrokythuat@utc.edu.vn"));
    }
}
