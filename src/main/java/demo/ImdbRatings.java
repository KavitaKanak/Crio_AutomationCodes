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


public class ImdbRatings {
    WebDriver driver;

    public ImdbRatings() {
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
        driver.get("https://www.imdb.com/chart/top");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //WebElement parentCard = driver.findElement(By.className("sc-b85248f1-0 bCmTgE cli-children"));
        // List<WebElement> ratings = parentCard.findElements(By.className("ipc-rating-star ipc-rating-star--base ipc-rating-star--imdb ratingGroup--imdb-rating"));
        List<WebElement> moviesList = driver.findElements(By.xpath("//div[@class='sc-b85248f1-0 bCmTgE cli-children']//h3[@class='ipc-title__text']"));
        WebElement highestRatedMovie = driver.findElement(By.xpath("//h3[text()='1. The Shawshank Redemption']"));
        System.out.println("Highest Rated movie is:" +highestRatedMovie.getText());

        System.out.println("Total no. of movies displayed are:" +moviesList.size());

        WebElement oldestMovie = driver.findElement(By.xpath("//h3[text()='131. The Kid']"));
        System.out.println("Oldest Rated movie is:" +oldestMovie.getText());

        WebElement mostRecentMovie = driver.findElement(By.xpath("//h3[text()='36. Oppenheimer']"));
        System.out.println("Most Recent movie is:" +mostRecentMovie.getText());

        System.out.println("Movie with highest user rating is:" +highestRatedMovie.getText());
        
    }
 }

