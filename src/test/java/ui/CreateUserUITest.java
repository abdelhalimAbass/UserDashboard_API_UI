package ui;

import base.BaseTest;
import data.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateUserUITest extends BaseTest {
WebDriver driver;
@BeforeMethod
public void Open_driver(){
    driver = new ChromeDriver();
    WebDriverManager.chromedriver().setup();
    driver.manage().window().maximize();

}
    @Test(priority = 0)
    public void createUserUI() throws InterruptedException {


        driver.get(TestData.Signup_url);

        driver.findElement(By.cssSelector("input[id=\"phone\"]"))
                .sendKeys(TestData.mobile);
        driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("P@ssw0rd");
        driver.findElement(By.cssSelector("input[id=\"confirm-password\"]")).sendKeys("P@ssw0rd");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pv_id_3\"]/span")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement User_Type= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pv_id_3_0\"]/span")));
        User_Type.click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/main/div[2]/form/div[5]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/main/div[2]/form/div[6]/button")).click();
        WebElement OTP=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("code")));
       OTP.sendKeys("1234");
       driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        String Expected_url="https://user-dashboard-smartsaving-beta.dafagate.com/index";
        Thread.sleep(2000);
        Assert.assertEquals(Expected_url,driver.getCurrentUrl());


    }
    @Test(priority = 1)
    public  void test_login() throws InterruptedException {
        driver.get(TestData.Signin_url);
        driver.findElement(By.id("mobile-number")).sendKeys(TestData.mobile);
        driver.findElement(By.id("password")).sendKeys("P@ssw0rd");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement OTP =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("code")));
        OTP.sendKeys("1234");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        String Expected_url="https://user-dashboard-smartsaving-beta.dafagate.com/index";
        Thread.sleep(2000);
        Assert.assertEquals(Expected_url,driver.getCurrentUrl());
    }
    @Test (priority = 2)
    public void fill_KYC() throws InterruptedException {
        driver.get(TestData.Signin_url);
        driver.findElement(By.id("mobile-number")).sendKeys(TestData.mobile);
        driver.findElement(By.id("password")).sendKeys("P@ssw0rd");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement OTP =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("code")));
        OTP.sendKeys("1234");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/main/div[1]/div/div[1]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[placeholder=\"Enter Your National Id\"]")).sendKeys(TestData.national_ID);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/form/button")).click();
        //WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        Thread.sleep(20000);
        WebElement Data_type=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"kyc_25_176\"]/div/div/div/div/div/div/div/span[1]")));
        Data_type.click();
        driver.findElement(By.xpath("//*[@id=\"pv_id_37\"]/span")).click();
        WebElement Gender=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pv_id_37_0\"]/span")));
        Gender.click();
        driver.findElement(By.xpath("//*[@id=\"pv_id_38\"]/span")).click();
        WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pv_id_38_4\"]/span")));
        title.click();
        driver.findElement(By.xpath("//*[@id=\"pv_id_39\"]/span")).click();
        WebElement status=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pv_id_39_0\"]")));
        status.click();
        driver.findElement(By.xpath("//*[@id=\"kyc_25_139\"]")).click();
//       WebElement place_of_birth= driver.findElement(By.xpath("//*[@id=\"kyc_25_139\"]"));
//       Thread.sleep(2000);
//        System.out.println(place_of_birth.isDisplayed());
//       place_of_birth.sendKeys("sudi arabia");
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"kyc_25_139\"]")));
        saveBtn.click();
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("kyc_25_141")));
        element.click();
       // element.sendKeys("hhhhhh");
        driver.findElement(By.xpath("//*[@id=\"pv_id_41\"]/span")).click();
        WebElement Martial_Status=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pv_id_41_1\"]")));
        Martial_Status.click();


       // driver.findElement(By.xpath("//*[@id=\"kyc_25_141\"]")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id=\"pv_id_42\"]/span")).click();
        WebElement Education_level=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pv_id_42_2\"]/span")));
        Education_level.click();
       WebElement place_op_birth=wait.until(ExpectedConditions.elementToBeClickable(By.id("kyc_25_151")));
        //place_op_birth.clear();
        place_op_birth.sendKeys("55");
       // driver.findElement(By.id("kyc_25_139")).sendKeys("5555");
       // driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/main/div/div/form/div[4]/div/button")).click();
        //id="kyc_25_139"




    }
//    @AfterMethod
//    public void after_method(){
//    if(driver!=null)
//        driver.quit();
//   }
}
