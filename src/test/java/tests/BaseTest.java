package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ScreenshotListener.class)
public class BaseTest {
//    protected WebDriver driver;
    protected String baseUrl;
    public WebDriver driver;

    @BeforeEach
    public void setUp() {
        baseUrl = ConfigReader.getProperty("baseUrl");
        ChromeOptions options = new ChromeOptions();


        options.addArguments("--headless=new");

        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");


        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");


        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}