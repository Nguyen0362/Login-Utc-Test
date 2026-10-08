package com.example.selenium.tests.utc;

import com.example.selenium.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Văn phòng điện tử UTC")
@Feature("Kiểm thử Giao diện (UI Testing)")
@DisplayName("TC19: Kiểm tra hiển thị hình ảnh banner và khẩu hiệu")
public class TC19_BannerAndSloganTest extends BaseTest {

    @BeforeEach
    public void setupTest() {
        driver.get("https://vanphongdientu.utc.edu.vn/Login");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC19: Hiển thị ảnh minh họa và khẩu hiệu 'Làm việc mọi lúc mọi nơi'")
    public void testBannerAndSlogan() {
        boolean isImgDisplayed = driver.findElement(By.cssSelector(".left img")).isDisplayed();
        String bannerTitle = driver.findElement(By.cssSelector(".caption h1")).getText();
        String bannerSubtitle = driver.findElement(By.cssSelector(".caption span")).getText();

        assertTrue(isImgDisplayed, "Ảnh banner phải hiển thị");
        assertTrue(bannerTitle.contains("Không chỉ là một giải pháp quản lý"), "Khẩu hiệu chính không đúng");
        assertTrue(bannerSubtitle.contains("Làm việc mọi lúc mọi nơi"), "Khẩu hiệu phụ không đúng");
    }
}
