package Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExercise {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void test01(){
        driver.findElement(By.xpath("//*[contains(text(),'Click for JS Alert')]")).click();
        driver.switchTo().alert().accept();
        String exceptionResult = "You successfully clicked an alert";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(exceptionResult,actualResult);
    }
    @Test
    public void test02(){
        driver.findElement(By.xpath("//*[contains(text(),'Click for JS Confirm')]")).click();
        driver.switchTo().alert().dismiss();
        String notWanttoText = "successfully";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertFalse(actualResult.contains(notWanttoText));
    }
    @Test
    public void test03(){
        driver.findElement(By.xpath("//*[contains(text(),'Click for JS Prompt')]")).click();
        driver.switchTo().alert().sendKeys("Turgay sefa");
        driver.switchTo().alert().accept();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String exceptionresult = "Turgay sefa";
        Assert.assertTrue(actualResult.contains(exceptionresult));

    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
