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

public class Register {

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

        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        driver.manage().window().maximize();
         Thread.sleep(2000); // kotokkhn dhore rakbe seta bujhaise .. mane delay time r ki
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//      return driver;
//      driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[2]/div/div/div[2]/div[1]/div/div/div[2]/h5")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()=\"First Name \"]/following-sibling::input[1]")).click();
        driver.findElement(By.xpath("//label[text()=\"First Name \"]/following-sibling::input[1]")).sendKeys("Shaharehar");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()=\"First Name \"]/following-sibling::input[2]")).click();
        driver.findElement(By.xpath("//label[text()=\"First Name \"]/following-sibling::input[2]")).sendKeys("Anik");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()=\"First Name \"]/following-sibling::input[3]")).click();
        driver.findElement(By.xpath("//label[text()=\"First Name \"]/following-sibling::input[3]")).sendKeys("shaharearanik@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type=\"password\"])[1]")).click();
        driver.findElement(By.xpath("(//input[@type=\"password\"])[1]")).sendKeys("password");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//input[@type=\"password\"])[2]")).click();
        driver.findElement(By.xpath("(//input[@type=\"password\"])[2]")).sendKeys("password");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()=\"Register\"]")).click();
        //driver.findElement(By.xpath("//*[@id=\"page\"]/div/div[6]/section/div/div/div/div/section/div[2]/div[2]/div[1]/div/section")).click();

    }
}

