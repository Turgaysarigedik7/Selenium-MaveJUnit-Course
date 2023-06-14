package Hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BeforeClassAfterClass {
   static WebDriver driver;
    @BeforeClass
    public static void SetUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void TearDown(){
        driver.close();
    }
    @Test
    public void method01(){
        driver.get("https://amazon.com.tr");
    }
}
