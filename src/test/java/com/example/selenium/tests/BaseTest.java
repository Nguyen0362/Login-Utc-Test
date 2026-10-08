package com.example.selenium.tests;

import com.example.selenium.config.ConfigReader;
import com.example.selenium.driver.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeEach
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        baseUrl = ConfigReader.get("baseUrl", "https://www.google.com");
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
