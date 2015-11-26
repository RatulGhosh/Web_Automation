
package selenium;

/**
 *
 * @author Ratul
 */
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class Downloading_images {

    public static void main(String[] args) throws IOException {
        
        FirefoxProfile profile = new FirefoxProfile();
        File file = new File("fn.xpi");
        profile.addExtension(file);
        
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", "C:\\Users\\Ratul\\Pictures");
        
        WebDriver driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new Point(1080, 0));
        driver.manage().window().setSize(new Dimension(1080/2, 768));

        driver.get("https://unsplash.com/");
        driver.findElement(By.className("icon-grid-multi")).click();

        for (int i = 0; i < 50; i++) {
            driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
        }

        Pattern p = Pattern.compile("/photos/(.*?)/download");
        Matcher m = p.matcher(driver.getPageSource());
        
        Set<String> urls = new LinkedHashSet<>();
        
        while (m.find()) {
            urls.add("https://unsplash.com"+ m.group());
        }
        System.out.println("Size of urls : "+ urls.size());
        for(String url: urls){
            driver.get(url);
            Actions action = new Actions(driver).doubleClick(driver.findElement(By.tagName("img")));
            action.build().perform();
        }
        
    }

}
