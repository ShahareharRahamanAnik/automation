import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class mouseRover {

    public static WebDriver driver;
    @Test
    public void  browser() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        Map<String, Integer> contentSettings = new HashMap<String, Integer>();
        //0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("notifications", 2);
        contentSettings.put("geolocation", 2);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);


        //MOUSE ROVER
        Actions actions = new Actions(driver);
        /*
        WebElement element = driver.findElement(By.xpath("//a[@href =\"https://www.hyrtutorials.com/search/label/Tutorials\"]"));
        actions.moveToElement(element).perform();
*/
        actions.moveToElement(driver.findElement(By.xpath("//a[@href =\"https://www.hyrtutorials.com/search/label/Tutorials\"]"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//a[@href=\"https://www.hyrtutorials.com/search/label/Testing\"]"))).perform();
        driver.findElement(By.xpath("//a[@href=\"https://www.hyrtutorials.com/search/label/Selenium\"]")).click();
    }
}

