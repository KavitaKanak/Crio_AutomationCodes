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

public class ImageUrls {
    WebDriver driver;
    
    public ImageUrls(){
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
// Navigate to Bookmyshow link  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // Thread.sleep(10000);
//Scroll into View 'Premieres' section
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='Premieres']")));

        WebElement prem = driver.findElement(By.xpath("//h2[text()='Premieres']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView();", prem);

// Identify list of webelements with <img> tag Using Locator "XPath" //div[@class='sc-133848s-2 sc-1t5vwh0-1 gTzZQd']//img
WebElement parentCard = driver.findElement(By.className("sc-dv5ht7-0 fiAaps"));
List<WebElement> images = driver.findElements(By.xpath("//div[@class='sc-133848s-2 sc-1t5vwh0-1 gTzZQd']//img"));
// Print the urls using getAttrinute("src")  
for(WebElement img : images){
    System.out.println("Image url:" +img.getAttribute("src"));

}
// Locate Name webelement of 2nd item in 'Premiere List' Using Locator "XPath" 
List<WebElement> movieNames = parentCard.findElements(By.className("sc-7o7nez-0 iHsoLV"));
String movieNameOfSecondItem = movieNames.get(1).getText();
// Print name using .getText()  
System.out.println("Name of 2nd item in list is:" +movieNameOfSecondItem);
// Locate Language webelement of 2nd item in 'Premiere List' Using Locator "XPath" //div[text()='German']/following::h3[text()='The Silent Forest']
List<WebElement> languagesNames = parentCard.findElements(By.className("sc-7o7nez-0 kHxEsI"));
String languageOfSecondItem = languagesNames.get(1).getText();
// Print language using .getText();  
System.out.println("Language of 2nd item in list is:" +languageOfSecondItem);
    }
}
