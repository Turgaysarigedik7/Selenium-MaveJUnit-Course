package Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownTestCase {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void dropdownTestMethod(){
        driver.get("https://www.amazon.com/");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Pet Supplies");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))
                .sendKeys("cat bed"+ Keys.ENTER);
        driver.findElement(By.xpath("//li[@id='p_89/Majestic Pet']//i[@class='a-icon a-icon-checkbox']"))
                .click();
        driver.findElement(By.xpath("//span[contains(text(),'Up to $25')]")).click();
        List<WebElement> countOfResult = driver
                .findElements(By.cssSelector(".a-section.a-spacing-base"));
        Assert.assertEquals(9,countOfResult.size());

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
