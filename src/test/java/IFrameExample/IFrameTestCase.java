package IFrameExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameTestCase {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void iFrameTestMethod(){
        driver.get("https://the-internet.herokuapp.com/tinymce");

        WebElement textFrame= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(textFrame.isEnabled());
        System.out.println(textFrame.getText());

        WebElement iFrame= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);
        WebElement iFrameElement= driver.findElement(By.xpath("//body[@id='tinymce']"));
        iFrameElement.clear();
        iFrameElement.clear();
        iFrameElement.sendKeys("Hello world");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.close();
    }
}
