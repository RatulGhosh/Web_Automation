package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author Ratul
 */
public class Selenium {

    public static void main(String[] args) {
        
        
        WebDriver driver = new FirefoxDriver();
        
        //Some pages might take long time to load so we have to wait untill ihe page loads completely
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.manage().window().setPosition(new Point(0,0));
		//depends upon your screen resolution
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.get("https://www.indeed.com");
        driver.findElement(By.id("what")).clear();
        driver.findElement(By.id("what")).sendKeys("Designers");
        driver.findElement(By.id("where")).clear();
        driver.findElement(By.id("where")).sendKeys("Kolkata");
        driver.findElement(By.id("fj")).click();
        System.out.println(driver.findElement(By.id("searchCount")).getText());
    }

}
