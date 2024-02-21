package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    @Setter
    @Getter
    public static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }


    public static void initializeDriver() {

        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        // Navigate to the website
        driver.get("https://www.saucedemo.com/");
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            System.out.println(" ");
        }
    }
}
