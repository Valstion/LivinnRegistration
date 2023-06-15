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
        int min = 1000000;
        int max = 9999999;
        int rndNum = min + (int) Math.round(Math.random() * (max - min));
        driver.get("https://10minutemail.net/?lang=ru");
        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        String mail = driver.findElement(By.xpath("//*[@id=\"fe_text\"]")).getAttribute("value");
        System.out.println(mail);
        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        driver.get("https://www.livinn.lt/register");
        driver.findElement(By.id("sylius_customer_registration_firstName")).sendKeys("DEDobosrka");
        driver.findElement(By.id("sylius_customer_registration_lastName")).sendKeys("SrakaDraka");
        driver.findElement(By.id("sylius_customer_registration_email")).sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"website-content\"]/div/div/div/section/form/div/div[5]/div/div/div/div/div/input")).sendKeys("6" + rndNum);
        driver.findElement(By.id("sylius_customer_registration_user_plainPassword")).sendKeys("Emaxerewq69");
        driver.findElement(By.xpath("//*[@id=\"website-content\"]/div/div/div/section/form/div/div[7]/div/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"website-content\"]/div/div/div/section/form/div/div[8]/input")).click();
        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
         driver.findElement(By.xpath("//*[@id=\"verification-form\"]/button")).click();

       // driver.get("https://10minutemail.net/?lang=ru");
        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        //driver.get("https://10minutemail.net/?lang=ru");
       // driver.findElement(By.xpath("//*[@id=\"left\"]/ul/li[1]/a")).click();


//listWebElement visi mailai. paimi masyvo ilgi. t.y kek gavai mailu. ir saugai int kintamajame

        //while(true){
//listWebElement visi mailai. paimi masyvo ilgi. t.y kek gavai mailu. ir saugai int kintamajame kuris sukurtas while cikle
        //if( pirmas ilgis nelygusantram){
        //break;}
        //click first email.

     //   driver.findElement(By.xpath("//*[@id=\"maillist\"]/tbody/tr[2]/td[1]/a")).click();
       // driver.findElement(By.xpath("//*[@id=\"tab1\"]/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table[3]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/a")).click();


      //  driver.get("https://www.livinn.lt/login");
    //    try {
     //       Thread.sleep(1000);
    //    } catch (InterruptedException e) {
     //   }
     //   driver.findElement(By.xpath("//*[@id=\"_username\"]")).sendKeys("mail");
      //  driver.findElement(By.xpath("//*[@id=\"_password\"]")).sendKeys("Emaxerewq69");
      //  driver.findElement(By.xpath("//*[@id=\"website-content\"]/div/div/div[1]/div/form/div/button")).click();
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
        driver.close();
    }
}

