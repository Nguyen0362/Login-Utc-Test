package com.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumDemoApp {
    public static void main(String[] args) {
        System.out.println("=== Khởi động Selenium Demo ===");

        // Thiết lập tùy chọn cho Chrome (hỗ trợ cả headless nếu cần)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // Bật dòng bên dưới nếu muốn chạy ngầm (không hiện cửa sổ trình duyệt):
        // options.addArguments("--headless=new");

        // Selenium 4 tích hợp sẵn Selenium Manager, tự động tải ChromeDriver tương ứng
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();

            // 1. Mở trang web mẫu
            System.out.println("Đang truy cập https://www.google.com ...");
            driver.get("https://www.google.com");

            System.out.println("Tiêu đề trang: " + driver.getTitle());

            // 2. Tìm ô tìm kiếm
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));

            // 3. Nhập từ khóa và submit
            String keyword = "Selenium WebDriver Java";
            System.out.println("Đang tìm kiếm từ khóa: " + keyword);
            searchBox.sendKeys(keyword);
            searchBox.submit();

            // 4. Đợi kết quả hiển thị
            wait.until(ExpectedConditions.titleContains("Selenium"));
            System.out.println("Tiêu đề trang sau tìm kiếm: " + driver.getTitle());

            System.out.println("=== Test chạy thành công! ===");
        } catch (Exception e) {
            System.err.println("Đã xảy ra lỗi: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            if (driver != null) {
                driver.quit();
                System.out.println("Đã đóng trình duyệt.");
            }
            System.exit(0);
        }
    }
}
