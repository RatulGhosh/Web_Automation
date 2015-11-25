
package selenium;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 *
 * @author Ratul
 */
public class Twitter_Counter {
      public static void main(String[] args) {
       
      WebDriver driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      
      PrintWriter writer=null;
        try {
           writer = new PrintWriter("top1000.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
      
      for(int i =0; i<2; i++){
          driver.get("http://twittercounter.com/pages/100/"+(i*100));
          List<WebElement> uname =driver.findElements(By.className("uname"));
          for(WebElement e : uname){
              writer.println(e.getAttribute("href").replace("http://twittercounter.com", "https://twitter.com"));
          }
      }
      writer.close();
      
    }
}
