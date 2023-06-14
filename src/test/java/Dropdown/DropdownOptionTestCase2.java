package Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownOptionTestCase2 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void optionTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement drp = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(drp);
        select.selectByIndex(1);
        Assert.assertEquals("Option 1",select.getFirstSelectedOption().getText());
        select.selectByIndex(2);
        Assert.assertEquals("Option 2",select.getFirstSelectedOption().getText());
        List<WebElement> optionList = select.getOptions();
        int exceptionOptionCount =2;
        Assert.assertEquals(exceptionOptionCount,(optionList.size()-1));
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
