package RadioButtonCheckBoxAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
    WebDriver driver;
    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void checkboxTestMethod(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox01= driver.findElement(By.xpath("(//form[@id='checkboxes']//input)[1]"));
        WebElement checkBox02= driver.findElement(By.xpath("(//form[@id='checkboxes']//input)[2]"));
        Assert.assertFalse(checkBox01.isSelected());
        Assert.assertTrue(checkBox02.isSelected());
        checkBox01.click();
        checkBox02.click();
        Assert.assertTrue(checkBox01.isSelected());
        Assert.assertFalse(checkBox02.isSelected());

    }
    @After
    public void TearDown(){
        driver.close();
    }
}
