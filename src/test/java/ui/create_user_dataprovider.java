package ui;

import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static data.TestData.driver;

public class create_user_dataprovider  extends TestData {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"123456789", "P@ssw0rd"},      // valid
                {"01012345678", "000000"},      // wrong password
                {"01000000000", "123456"},      // wrong mobile
                {"", "123456"},                 // empty mobile
                {"01012345678", ""}             // empty password
        };
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String mobile, String password) throws InterruptedException {
        driver=new ChromeDriver();
        driver.get(Signup_url);
        driver.findElement(By.cssSelector("input[id=\"phone\"]")).clear();
        driver.findElement(By.cssSelector("input[id=\"phone\"]")).sendKeys(mobile);

        driver.findElement(By.cssSelector("input[id=\"password\"]")).clear();
        driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys(password);

        driver.findElement(By.cssSelector("input[id=\"confirm-password\"]")).sendKeys(password);

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

        //driver.findElement(By.id("loginBtn")).click();

        // مثال تحقق بسيط
        if (mobile.equals("123456789") && password.equals("P@ssw0rd")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        } else {
            Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));
        }
    }

}
