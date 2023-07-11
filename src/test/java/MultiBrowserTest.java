import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static java.awt.SystemColor.window;

public class MultiBrowserTest {
    public static WebDriver driver;
    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(new FirefoxProfile());
            options.addPreference("dom.webnotifications.enabled", false);
            options.addPreference("geo.enabled", true);
            options.addPreference("geo.prompt.testing", true);
            options.addPreference("geo.prompt.testing.allow", true);
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("chrome")) {
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


        }
    }
        @Test
                public void test() throws InterruptedException {


            driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
            driver.manage().window().maximize();
         Thread.sleep(2000); // kotokkhn dhore rakbe seta bujhaise .. mane delay time r ki
           //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//      return driver;
//      driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/h5")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[1]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[1]")).sendKeys("Shaharehar");
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[2]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[2]")).sendKeys("Anik");
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[3]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[3]")).sendKeys("shaharearanik");

//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript(window.s());

            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/div[2]/input")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/div[2]/input")).sendKeys("password");
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[4]")).click();
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/input[4]")).sendKeys("password");
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/article/div/div/form/div[1]/div[3]/button[1]")).click();
            //   driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[6]/section/div/div/div/div/section/div[2]/div[2]/div[1]/div/section")).click();
         driver.quit();
    }
}
