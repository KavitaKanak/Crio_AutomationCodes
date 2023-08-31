package demo;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Linkedin {
    WebDriver driver;

    public Linkedin(){
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
// Launch LinkedIn  https://www.linkedin.com/feed/
driver.get("https://www.linkedin.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
// Locate 'Email or phone ' field Using Locator "XPath" //input[@name='session_key']
WebElement phoneNumber = driver.findElement(By.id("session_key"));
//WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='session_key']"));
// senkeys to Email  8291068315
phoneNumber.sendKeys("8291068315");
// Locate 'Password ' field Using Locator "XPath" //input[@id='session_password']
WebElement password = driver.findElement(By.id("session_password"));
//WebElement password = driver.findElement(By.xpath("//input[@id='session_password']"));
// sendkeys to Password  GivemeJob@12
password.sendKeys("GivemeJob@12");
// Locate 'Sign-in' button Using Locator "XPath" //button[@data-id='sign-in-form__submit-btn']
WebElement signIn = driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']"));
// click 'Sign-in' button  
signIn.click();
// Thread.sleep(2000)
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));  
// Locate and click 'Me' Using Locator "XPath" //span[text()='Me']
WebElement meButton = driver.findElement(By.xpath("//span[text()='Me']"));
meButton.click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1)); 
// Click 'View Profile' Using Locator "XPath" //div[@id='ember16']
WebElement viewProfile = driver.findElement(By.xpath("//a[@class='ember-view block']"));
viewProfile.click();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); 
// Locate 'Profile Views' Using Locator "XPath" //span[contains(text(), 'profile views') and @aria-hidden='true']
WebElement profileViews = driver.findElement(By.xpath("//span[contains(text(), 'profile views') and @aria-hidden='true']"));
// apply .getText to webElement for no. of profile views 
String noOfProfileViews =  profileViews.getText();
System.out.println("Total no. of profile views are: " +noOfProfileViews);
// Locate Post impressions Using Locator "XPath" //span[contains(text(), 'post') and @aria-hidden='true']
WebElement postImpressions = driver.findElement(By.xpath("//span[contains(text(), 'post') and @aria-hidden='true']"));
// apply .getText to webElement for no. of post impressions 
String noOfPostImpressions =  postImpressions.getText();
System.out.println("Total no. of Post Impressions are:" +noOfPostImpressions);
// Locate 'Create a Post' button Using Locator "XPath" //span[text()='Create a post' and @class='pvs-navigation__text']
WebElement createPost = driver.findElement(By.xpath("//span[text()='Create a post' and @class='pvs-navigation__text']"));
// click on 'Create a post' button 
 createPost.click();
// Locate and Select 'Post with anyone' dropdown Using Locator "XPath" //div[@id='ember5279']
WebElement postWithAnyone = driver.findElement(By.xpath("//div[@class='truncate artdeco-entity-lockup__subtitle ember-view']"));
postWithAnyone.click();
// Locate and Select 'Share with Connections only' option Using Locator "XPath" //button[@id='CONNECTIONS_ONLY']
WebElement shareWithConnections = driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']//span[2]/span"));
shareWithConnections.click();
// Locate and click on 'Done' Using Locator "XPath" //span[text()='Done' and @class='artdeco-button__text']
WebElement doneButton = driver.findElement(By.xpath("//span[text()='Done' and @class='artdeco-button__text']"));
doneButton.click();
// Sendkeys to 'Post' textarea. Using Locator "XPath" //div[@data-placeholder='What do you want to talk about?'] | Change is the only Constant
WebElement postArea = driver.findElement(By.xpath("//div[@data-placeholder='What do you want to talk about?']"));
postArea.sendKeys("Change is the only Constant");
// Locate and click 'Post' button Using Locator "XPath" //span[text()='Post' and @class='artdeco-button__text']
WebElement postButton = driver.findElement(By.xpath("//span[text()='Post' and @class='artdeco-button__text']"));
postButton.click(); 
// Verify if 'Post successful' pop-up appears using explicit wait Using Locator "XPath" //p[@class='artdeco-toast-item__message']
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='artdeco-toast-item__message']")));
System.out.println("Post was uploaded successfully");

}
}
