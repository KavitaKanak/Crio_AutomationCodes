package demo;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;



public class NestedFrames {
    WebDriver driver;

    public NestedFrames(){
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

    public  void testCase01() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println("Left Frame Text is:" +driver.findElement(By.tagName("body")).getText());
       
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        System.out.println("Middle Frame Text is:" +driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println("Right Frame Text is:" +driver.findElement(By.tagName("body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        System.out.println("Right Frame Text is:" +driver.findElement(By.tagName("body")).getText());

        driver.switchTo().defaultContent();
    }
}
