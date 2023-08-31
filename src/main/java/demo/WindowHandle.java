package demo;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.lang.Thread;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
    WebDriver driver;

    public WindowHandle() {
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
// Navigate to link  https://www.w3schools.com/jsref/tryit.aspfilename=tryjsref_win_open
driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
String parentwindow = driver.getWindowHandle();

driver.switchTo().frame("iframeResult");
// Locate and click 'Try it' button Using Locator "XPath" //button[@onclick='myFunction()']
WebElement tryElement = driver.findElement(By.xpath("//button[text()='Try it']"));
tryElement.click();

Set<String> s = driver.getWindowHandles();
Iterator<String> I1 = s.iterator();

while (I1.hasNext()) {
        String child_window = I1.next();
        
        if (!parentwindow.equals(child_window)) {
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getCurrentUrl());
                System.out.println(driver.switchTo().window(child_window).getTitle());

                driver.close();
        }
} 
driver.switchTo().window(parentwindow);  
    }
}
