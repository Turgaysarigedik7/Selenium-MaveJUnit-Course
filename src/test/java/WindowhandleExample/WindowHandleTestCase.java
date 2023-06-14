package WindowhandleExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandleTestCase
{
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void handleTestMethod(){
        driver.get("https://trendyol.com/");
        driver.findElement(By.xpath("//div[@id='gender-popup-app']//div[@class='modal-close']"))
                .click();
        String firstPageWindowhashCode = driver.getWindowHandle();
        driver.findElement(By.xpath("//input[@class='V8wbcUhU']"))
                .sendKeys("Cüzdan"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='p-card-chldrn-cntnr card-border'])[1]"))
                .click();
        Set<String> allHandleCodes = driver.getWindowHandles();
        String secondPageWindowhandleCode = "";
        for (String each: allHandleCodes) {
            if(!each.equals(firstPageWindowhashCode))
                secondPageWindowhandleCode=each;
        }
        System.out.println("First Hash code: "+ firstPageWindowhashCode);
        System.out.println("Second Hash code: "+secondPageWindowhandleCode);

        driver.switchTo().window(secondPageWindowhandleCode);
        driver.findElement(By.xpath("//span[normalize-space()='Daha Fazla Bershka Cüzdan']//parent::a"))
                .click();
        Set<String> allHandleCodes2 = driver.getWindowHandles();
        String thirdPageWindowHashCode = "";

        for (String each:allHandleCodes2) {
            if(!each.equals(firstPageWindowhashCode) && !each.equals(secondPageWindowhandleCode))
                thirdPageWindowHashCode = each;
        }
        System.out.println("Third Hash code: "+thirdPageWindowHashCode);
        driver.findElement(By.xpath("//input[@class='V8wbcUhU']"))
                .sendKeys("Kedi maması"+ Keys.ENTER);
        driver.switchTo().window(firstPageWindowhashCode);
        String firstPageUrl = driver.getCurrentUrl();
        System.out.println("First Page Url: "+firstPageUrl);
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.close();
    }
}
