import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class PROJECT_2 {

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

//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--headless");
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("https://chaldal.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000); // kotokkhn dhore rakbe seta bujhaise .. mane delay time r ki
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//      return driver;
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/h5")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input")).sendKeys("cocola egg noodles");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[1]/div[1]/form/div/div[1]/input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[6]/section/div/div/div/div/section/div[2]/div[2]/div[1]/div/section")).click();

    }
}

