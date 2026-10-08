# Selenium Java Maven Project

Dự án Java Maven mẫu đã được tích hợp **Selenium WebDriver (4.27.0)** và **JUnit 5 (5.11.3)**.

## Cấu trúc thư mục

```text
selenium-java-project/
├── pom.xml                                   # Cấu hình Maven dependencies & plugins
├── .gitignore
├── README.md
└── src/
    ├── main/
    │   └── java/com/example/selenium/
    │       └── SeleniumDemoApp.java          # Chương trình Java chạy trực tiếp (main method)
    └── test/
        └── java/com/example/selenium/
            └── SeleniumBasicTest.java        # Test script sử dụng JUnit 5
```

## Tính năng nổi bật
- **Selenium 4**: Tự động quản lý trình điều khiển trình duyệt (ChromeDriver, EdgeDriver, GeckoDriver...) thông qua **Selenium Manager** tích hợp sẵn, không cần tải `chromedriver.exe` thủ công.
- **JUnit 5**: Hỗ trợ viết và chạy automation test suite chuẩn ngành.
- **Hỗ trợ Headless Mode**: Chạy kiểm thử tự động không mở UI trình duyệt hoặc mở UI trực quan tuỳ ý.

## Cách chạy dự án

### 1. Biên dịch dự án
```bash
mvn clean compile
```

### 2. Chạy ứng dụng trực tiếp (`SeleniumDemoApp`)
```bash
mvn compile exec:java
```

### 3. Chạy kiểm thử tự động với JUnit 5
```bash
mvn test
```
