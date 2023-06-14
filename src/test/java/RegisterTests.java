import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTests {
    static WebDriver driver;
    @Test
    public void test() {
        int min= 1000000;
        int max = 9999999;
        int rndNum = min + (int) Math.round(Math.random() * (max - min));
        driver.findElement(By.id("sylius_customer_registration_firstName")).sendKeys("DEDobosrka");
        driver.findElement(By.id("sylius_customer_registration_lastName")).sendKeys("SrakaDraka");
        driver.findElement(By.id("sylius_customer_registration_email")).sendKeys("EFGama23axer" + rndNum + "@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"website-content\"]/div/div/div/section/form/div/div[5]/div/div/div/div/div/input")).sendKeys("6" +rndNum);
        driver.findElement(By.id("sylius_customer_registration_user_plainPassword")).sendKeys("Emaxerewq69");
        driver.findElement(By.xpath("//*[@id=\"website-content\"]/div/div/div/section/form/div/div[7]/div/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"website-content\"]/div/div/div/section/form/div/div[8]/input")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"verification-form\"]/button")).click();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        acceptCookies();
    }

    public void acceptCookies() {
        driver.get("https://www.livinn.lt/register");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @AfterClass
    public void afterClass() {
       // driver.close();
    }
}

