package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassTestCase {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void methodActionClass() throws InterruptedException {
        driver.get("https://amazon.com/");
        Actions actions = new Actions(driver);
        WebElement languageSelection = driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']//span[@class='nav-line-2']"));
        actions.moveToElement(languageSelection).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@href='#switch-lang=de_DE'])[1]")).click();

        Thread.sleep(5000);
        WebElement languageSelection2 = driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']//span[@class='nav-line-2']"));
        actions.moveToElement(languageSelection2).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@href='#switch-lang=en_US'])[1]")).click();

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);

    }
}
