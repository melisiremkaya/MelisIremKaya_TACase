package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    static WebDriver driver;

    public static WebDriver initializeDriver(String browser) {
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
            }
            else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Invalid browser: " + browser);
            }
        }
        return driver;
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
