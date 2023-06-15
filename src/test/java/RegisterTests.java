import org.example.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

    @Test
    public void positiveTest(){
        User u = new User("jonas","kisielius","jonokisielius10@gmail.com","68479974","Aa3456789");
        u.register();
        String text = "";
        try {
            text = User.driver.findElement(By.className("form-title")).getText();
        }catch (Exception e){}
        Assert.assertEquals(text,"Patvirtinkite paskyrą");
    }

    @Test
    public void noEmailAddressTest(){
        User u = new User("jonas","kisielius","","63777954","Aa3456789");
        u.register();
        Assert.assertEquals(errorMsg("email"),"Šis adresas yra neteisingas.");
    }

    @Test
    public void emailUserNoEtaNoDomainNoTopDomainTest(){
        User u = new User("jonas","kisielius","labas","63777954","Aa3456789");
        u.register();
        Assert.assertEquals(errorMsg("email"),"Šis adresas yra neteisingas.");
    }

    @Test
    public void emailUserEtaDomainNoTopDomainTest(){
        User u = new User("jonas","kisielius","labas@varle","63777954","Aa3456789");
        u.register();
        Assert.assertEquals(errorMsg("email"),"Šis adresas yra neteisingas.");
    }

    @Test
    public void emailWithSpaceInUserTest(){
        User u = new User("jonas","kisielius","labas vakaras@varle.lt","63777954","Aa3456789");
        u.register();
        Assert.assertEquals(errorMsg("email"),"Šis adresas yra neteisingas.");
    }

    @Test
    public void emailTooLongTest(){
        User u = new User("jonas","kisielius","labavakara".repeat(60) + "@varle.lt ","63777954","Aa3456789");
        u.register();
        Assert.assertEquals(errorMsg("email"),"El. paštas turi būti ilgesnis nei 255 simbolių.");
    }

    @Test
    public void emailWithLeadingTreilingSpacesTest(){
        User u = new User("jonas","kisielius"," labavakara@varle.lt ","63777954","Aa3456789");
        u.register();
        Assert.assertEquals(errorMsg("email"),"Šis adresas yra neteisingas.");
    }


    @BeforeClass
    public void beforeClass(){
        User.driver = new ChromeDriver();
        User.driver.manage().window().maximize();
        User.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        acceptCookies();
    }

    public String errorMsg(String field){
        String errorMsg = "";
        int position = 0;

        switch (field){
            case "name":
                position = 0;
                break;
            case "surname":
                position = 1;
                break;
            case "email":
                position = 2;
                break;
        }
        try {
            errorMsg = User.driver.
                    findElement(By.className("login-page-body--form")).
                    findElements(By.className("form-block")).get(position).
                    findElement(By.className("field-error")).getText();
        }catch (Exception e){}
        return errorMsg;
    }
    public void acceptCookies(){
        User.driver.get("https://www.livinn.lt/register");
        User.driver.findElement(By.id("onetrust-button-group")).click();
    }

    @AfterClass
    public void afterClass(){
        //  driver.close();
    }
}