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
        //TestData.mobile
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
        //TestData.mobile
        driver.findElement(By.id("password")).sendKeys("P@ssw0rd");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement OTP =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("code")));
        OTP.sendKeys("1234");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/main/div[1]/div/div[1]/button")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("input[placeholder=\"Enter Your National Id\"]")).sendKeys(TestData.national_ID);
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/form/button")).click();
        //WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        Thread.sleep(20000);
        WebElement Data_type=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"kyc_25_176\"]/div/div/div/div/div/div/div/span[1]")));
        Data_type.click();
       // driver.findElement().click();
        driver.findElement(By.xpath("//span[@aria-label=\"Gender\"]")).click();
        WebElement Gender=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Male')]")));
        Gender.click();
        driver.findElement(By.xpath("//span[@aria-label=\"Title\"]")).click();
        WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Eng')]")));
        title.click();
        driver.findElement(By.xpath("//span[@aria-label=\"Status\"]")).click();
        WebElement status=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Natural')]")));
        status.click();
        driver.findElement(By.xpath("//span[@aria-label=\"Martial Status\"]")).click();
        WebElement marital_status = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Married')]")));
        marital_status.click();
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@aria-label=\"Education Level\"]")));
        element.click();
        driver.findElement(By.xpath("//span[contains(text(),'Primary')]")).click();
        driver.findElement(By.xpath("//input[@data-pc-name='inputtext' and @name='kyc_25_151']\n")).sendKeys("1235");
        driver.findElement(By.cssSelector("input[name=\"kyc_25_152\"]")).sendKeys("input[name=\"kyc_25_152\"]");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //driver.findElement(By.xpath("//*[@id=\"pv_id_41\"]/span")).click();
        //WebElement Martial_Status=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pv_id_41_1\"]")));
       // Martial_Status.click();
        //driver.findElement(By.xpath("//*[@id=\"pv_id_42\"]/span")).click();
        //WebElement Education_level=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pv_id_42_2\"]/span")));
       // Education_level.click();
        //Thread.sleep(5000);
       // driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        // KYC page two
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-19\"]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-28\"]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-30\"]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-33\"]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-36\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-39\"]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-42\"]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-6\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-10\"]/span[1]")).click();

        WebElement page2Next=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type=\"submit\"]")));
        page2Next.click();
        //KYC page 3
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-47\"]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"kyc_32_154\"]/div/div/div/div/div/div[7]/div/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-51\"]/span[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"headlessui-radiogroup-option-56\"]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"kyc_32_158\"]/div/div/div/div/div/div[1]/div/span[1]")).click();
        driver.findElement(By.xpath("//input[@type=\"number\"]")).sendKeys("10");
        driver.findElement(By.xpath("//input[@type=\"text\" and @name=\"kyc_32_160\"]")).sendKeys("10");
        driver.findElement(By.xpath("//input[@type=\"text\" and @name=\"kyc_32_161\"]")).sendKeys("10.");
        driver.findElement(By.xpath("//input[@type=\"text\" and @name=\"kyc_32_162\"]")).sendKeys("10.");
        driver.findElement(By.xpath("//*[@id=\"kyc_32_157\"]/div/textarea")).sendKeys("10");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();






    }
    @AfterMethod
    public void after_method(){
    if(driver!=null)
        driver.quit();
   }
}
