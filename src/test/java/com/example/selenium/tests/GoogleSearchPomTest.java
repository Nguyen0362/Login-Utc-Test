package com.example.selenium.tests;

import com.example.selenium.pages.GoogleResultPage;
import com.example.selenium.pages.GoogleSearchPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchPomTest extends BaseTest {

    @Test
    @DisplayName("Kiểm thử tìm kiếm Google với mô hình Page Object Model")
    public void testSearchFlow() {
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        
        // 1. Mở trang Google
        searchPage.open(baseUrl);
        assertTrue(searchPage.getTitle().contains("Google"), "Tiêu đề trang phải chứa Google");

        // 2. Tìm kiếm từ khóa và chuyển tới trang kết quả
        GoogleResultPage resultPage = searchPage.searchFor("Selenium WebDriver Java");

        // 3. Kiểm tra kết quả
        assertTrue(resultPage.isResultPageDisplayed(), "Trang kết quả tìm kiếm hiển thị thành công");
    }
}
