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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Create_Corporate_user_UI extends BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void open_Driver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void SignUp() throws InterruptedException {
        driver.get(TestData.Signup_url);
        driver.findElement(By.cssSelector("input[id=\"phone\"]"))
                .sendKeys(TestData.mobile);
        driver.findElement(By.cssSelector("input[id=\"password\"]"))
                .sendKeys("P@ssw0rd");
        driver.findElement(By.cssSelector("input[id=\"confirm-password\"]"))
                .sendKeys("P@ssw0rd");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pv_id_3\"]/span")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement User_Type = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pv_id_3_1\"]/span")));
        User_Type.click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/main/div[2]/form/div[5]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/main/div[2]/form/div[6]/button")).click();
        WebElement OTP = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("code")));
        OTP.sendKeys("1234");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        String Expected_url = "https://user-dashboard-smartsaving-beta.dafagate.com/index";
        Thread.sleep(2000);
        Assert.assertEquals(Expected_url, driver.getCurrentUrl());
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
    @Test(priority = 2)
    public void Fill_KYB() throws InterruptedException {
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
//        if(Assert.assertEquals(driver.getCurrentUrl(),Expected_url))
//        {
//
//        }
       driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/main/div[1]/div/div[1]/button")).click();


    }
}

