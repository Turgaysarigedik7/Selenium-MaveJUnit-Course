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

import java.time.Duration;

public class RadioButton {
    WebDriver driver;

    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void raddioButtonTest() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/radiobutton");
        WebElement radioButton1= driver.findElement(By.xpath("//input[@value='option1']"));
        WebElement radioButton2= driver.findElement(By.xpath("//input[@value='option2']"));
        WebElement radioButton3= driver.findElement(By.xpath("//input[@value='option3']"));
        Assert.assertTrue(radioButton1.isSelected());
        Assert.assertFalse(radioButton2.isSelected());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        radioButton3.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
        Assert.assertFalse(radioButton1.isSelected());
        Assert.assertTrue(radioButton3.isSelected());

    }
    @After
    public void TearDown() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        //driver.close();
    }
}
