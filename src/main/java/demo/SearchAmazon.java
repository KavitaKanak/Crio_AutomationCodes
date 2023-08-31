package demo;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAmazon {
    ChromeDriver driver;

    public SearchAmazon(){
         System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
// Navigate to url  https://www.google.com
driver.get("https://www.google.com");
// SendKeys "amazon" Using Locator "XPath" //*[@name='q'] | amazon
WebElement searchBar = driver.findElement(By.xpath("//*[@name='q']"));
searchBar.sendKeys("amazon");
// click on Google Search button Using Locator "XPath" /html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[6]/center/input[1]
// WebElement googleSearchbutton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[6]/center/input[1]"));
// googleSearchbutton.click();
searchBar.sendKeys(Keys.ENTER);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
// Validate text amazon.in Using Locator "XPath" //*[text()='Amazon.com']
Boolean result = driver.findElement(By.xpath("//*[contains(text(), 'amazon.in') or contains(text(),'amazon.com')]")).isDisplayed();
//Validate text amazon.in Using Locator "XPath" //*[text()='Amazon.com'] is present or no
if(result == true){
    System.out.println("Amazon links are present");
}
else {
    System.out.println("Links are not present");
}

    }
    
}
